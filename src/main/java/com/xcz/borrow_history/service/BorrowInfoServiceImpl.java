package com.xcz.borrow_history.service;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.xcz.borrow_history.domain.BorrowHistory;
import com.xcz.borrow_history.domain.Reservation;
import com.xcz.common.BaseService;
import com.xcz.constant.MyConstant;
import com.xcz.recommendation.domain.RecomUionPK;
import com.xcz.recommendation.domain.Recommendation;
import com.xcz.search.domain.Book;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by yhq on 2016/10/9.
 */
public class BorrowInfoServiceImpl extends BaseService implements BorrowInfoService {

    public BorrowHistory[] check(String user_id) {
        String sql = "SELECT * FROM BORROW_HISTORY WHERE user_id = '"+ user_id +"'";
        List result = this.getHibernateDAO().findBySql(sql);
        if (result == null || result.isEmpty()){
            return null;
        }
        BorrowHistory[] data = new BorrowHistory[result.size()];
        for (int i=0; i<result.size(); i++){
            BorrowHistory t = new BorrowHistory();
            Object[] objects = (Object[]) result.get(i);
            t.getUionPK().setUser_id((String)objects[0]);
            t.getUionPK().setBook_id((String)objects[1]);
            Timestamp timestamp = (Timestamp) objects[2];
            Date date = new Date(timestamp.getTime());
            t.getUionPK().setDue_date(date);
            if (objects[3] != null) {
                timestamp = (Timestamp) objects[3];
                date = new Date(timestamp.getTime());
                t.setReturn_date(date);
            }
            data[i] = t;
        }
        return data;
    }

    // 通过id查询书籍
    public Book queryBook(String id) {
        String sql = "SELECT * FROM BOOK WHERE id = '"+ id +"'";
        List result = this.getHibernateDAO().findBySql(sql);
        if (result == null || result.isEmpty()){
            return null;
        }
        Book book = new Book();
        Object[] row =(Object[]) result.get(0);
        book.setId((String)row[0]);
        book.setISBN((String) row[1]);
        book.setBook_name((String)row[2]);
        book.setLang((String)row[3]);
        book.setAuthor((String)row[4]);
        book.setPress((String)row[5]);
        Timestamp timestamp = (Timestamp)row[6];
        book.setPub_year(timestamp.toString().substring(0,4));
        book.setCall_no((String)row[7]);
        book.setState((String)row[8]);
        book.setPages((Integer)row[9]);
        book.setSize((Integer)row[10]);
        book.setCover((String)row[11]);
        return book;
    }

    public ArrayList<Book> queryBooks(ArrayList<String> ISBNs) {
        ArrayList<Book> list = new ArrayList<Book>();
        for(int i=0; i<ISBNs.size(); i++){
            Book book = queryBook(ISBNs.get(i));
            if (book != null)
                list.add(book);
        }
        return list;
    }

    public Reservation[] queryReserve(String user_id) {
        String sql = "SELECT * FROM RESERVATION WHERE user_id = '"+ user_id +"'";
        List result = this.getHibernateDAO().findBySql(sql);
        if (result == null || result.isEmpty()){
            return null;
        }

        Reservation[] data = new Reservation[result.size()];
        for (int i=0; i<result.size(); i++){
            Reservation t = new Reservation();
            Object[] objects = (Object[]) result.get(i);
            t.getUionPK().setUser_id((String)objects[0]);
            t.getUionPK().setBook_id((String)objects[1]);
            //
            Timestamp timestamp = (Timestamp) objects[2];
            Date date = new Date(timestamp.getTime());
            t.setRes_date(date);
            t.setState((String) objects[3]);
            data[i] = t;
        }
        return data;
    }

    // 插入借书记录
    public String add(String user_id, String book_id) {
        Calendar temp = Calendar.getInstance().getInstance();
        temp.add(Calendar.MONTH,1);
        String date  = "{0}-{1}-{2}";
        date = date.replace("{0}",temp.get(Calendar.YEAR)+"");
        date = date.replace("{1}",temp.get(Calendar.MONTH)+1+"");
        date = date.replace("{2}",temp.get(Calendar.DAY_OF_MONTH)+"");
        String sql = "INSERT INTO BORROW_HISTORY (user_id, book_id, due_date) VALUES ('"+user_id+"', '"+book_id+"','"+date+"' );";
        String book_sql = "UPDATE BOOK SET state = '"+MyConstant.BORROWED+"' WHERE id = '"+book_id+"'";
        String msg;
        int historyCnt, bookCnt;
        historyCnt = bookCnt = 0;
        // 书本和用户已经检测过，此处只可能是重复主键
        try {
            historyCnt = this.getHibernateDAO().updateBySql(sql);
            if (historyCnt == 1){
                bookCnt = this.getHibernateDAO().updateBySql(book_sql);
            }
            if (historyCnt == 1 && bookCnt==1)
                msg = "Borrow Success!";
            else {
                msg = "Borrow have something wrong!";
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Borrow Failed!\nReaders are not allowed to borrow the same book more than one time a day!";
        }
        return msg;
    }

    public String returnBook(String book_id)
    {
        // 修改BORROW_HISTORY，添加return_date
        // 修改书的状态
        String sql = "UPDATE BORROW_HISTORY SET return_date = curdate() WHERE book_id = '"+book_id+"' AND return_date is NULL";
        String book_sql = "UPDATE BOOK SET state = '"+MyConstant.AVAILABLE+"' WHERE id = '"+book_id+"'";
        String res_sql = "UPDATE RESERVATION SET state = 'ok' WHERE book_id ='"+book_id+"'";
        String res_find_sql = "SELECT * FROM RESERVATION WHERE book_id = '"+book_id+"' AND state = 'waiting'";
        String msg;
        int historyCnt, bookCnt;
        historyCnt = bookCnt = 0;
        try {
            // 如果有借书记录，先修改借书记录，修改成功再查看有没有预约记录，如果有，更新预约状态。通知管理员将本书收起，没有则更新书籍状态
            historyCnt = this.getHibernateDAO().updateBySql(sql);
            if (historyCnt == 1) {
                int temp = this.getHibernateDAO().findCountBySql(res_find_sql);
                if(temp == 1){
                    bookCnt = this.getHibernateDAO().updateBySql(res_sql);
                    return "Return Success! This book is reserved,put it into the reservation shelf";
                }
                else {
                    bookCnt = this.getHibernateDAO().updateBySql(book_sql);
                }

            }
            if (bookCnt == 1) {
                msg = "Return Success!";
            } else if (bookCnt == 0){
                // 此处之前已确认书本存在，bookCnt为0，则代表没有该书的借书记录
                msg = "Return book failed!\nThis book is not borrowed!";
            } else {
                msg = "Return book failed!";
            }
        } catch (Exception e) {
            e.printStackTrace();
           msg = "Return book error!";
        }
        return msg;
    }

    @Override
    public Boolean checkUser(String id) {
        String sql = "SELECT * FROM USER WHERE id = '"+id+"'";
        int cnt = this.getHibernateDAO().findCountBySql(sql);
        return cnt == 1 ? true : false;
    }

    @Override
    public Double getFine(String id) {
        return queryAllFine(id);
    }

    public ArrayList<Recommendation> getRecByUser(String id) {
        String sql;
        sql = "SELECT * FROM RECOMMENDATION WHERE user_id = '"+ id +"'";
        List result = this.getHibernateDAO().findBySql(sql);
        if (result == null || result.size()==0)
            return null;
        ArrayList<Recommendation> data = new ArrayList<>();
        for(int i=0; i<result.size(); i++){
            Recommendation rec = new Recommendation();
            Object[] row = (Object[]) result.get(i);
            RecomUionPK uionPK = new RecomUionPK();
            uionPK.setUser_id((String)row[0]);
            uionPK.setISBN((String)row[5]);
            rec.setUionPK(uionPK);
            rec.setBook_name((String)row[1]);
            rec.setLang((String)row[2]);
            rec.setAuthor((String)row[3]);
            rec.setPress((String)row[4]);
            rec.setPrice((float)row[6]);
            rec.setAmount((Integer)row[7]);
            rec.setReason((String)row[8]);
            rec.setState((String)row[9]);
            data.add(rec);
        }
        return data;
    }
}
