package com.xcz.borrow_history.service;

import com.mysql.jdbc.SQLError;
import com.xcz.borrow_history.domain.BorrowHistory;
import com.xcz.borrow_history.domain.Reservation;
import com.xcz.common.BaseService;
import com.xcz.constant.MyConstant;
import com.xcz.search.domain.Book;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
    public Boolean add(String user_id, String book_id) {
        Calendar temp = Calendar.getInstance().getInstance();
        temp.add(Calendar.MONTH,1);
        String date  = "{0}-{1}-{2}";
        date = date.replace("{0}",temp.get(Calendar.YEAR)+"");
        date = date.replace("{1}",temp.get(Calendar.MONTH)+1+"");
        date = date.replace("{2}",temp.get(Calendar.DAY_OF_MONTH)+"");
        String sql = "INSERT INTO BORROW_HISTORY (user_id, book_id, due_date) VALUES ('"+user_id+"', '"+book_id+"','"+date+"' );";
        String book_sql = "UPDATE BOOK SET state = '"+MyConstant.BORROWED+"' WHERE id = '"+book_id+"'";
        try {
            this.getHibernateDAO().executeBySql(sql);
            System.out.println(book_sql);
            this.getHibernateDAO().executeBySql(book_sql);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    public String returnBook(String book_id)
    {
        String sql = "UPDATE BORROW_HISTORY SET return_date = curdate() WHERE book_id = '"+book_id+"'";
        String book_sql = "UPDATE BOOK SET state = '"+MyConstant.AVAILABLE+"' WHERE id = '"+book_id+"'";
        try {
            this.getHibernateDAO().executeBySql(sql);
            this.getHibernateDAO().executeBySql(book_sql);
            return "return success";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "no record: wrong id";
        }
    }
}
