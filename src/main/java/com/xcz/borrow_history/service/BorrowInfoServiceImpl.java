package com.xcz.borrow_history.service;

import com.mysql.jdbc.SQLError;
import com.xcz.borrow_history.domain.BorrowHistory;
import com.xcz.borrow_history.domain.Reservation;
import com.xcz.common.BaseService;
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
        String sql = "select * from BORROW_HISTORY where user_id = '"+ user_id +"'";
        List result = this.getHibernateDAO().findBySql(sql);
        if (result == null || result.isEmpty()){
            return null;
        }

        BorrowHistory[] data = new BorrowHistory[result.size()];
        for (int i=0; i<result.size(); i++){
            BorrowHistory t = new BorrowHistory();
            Object[] objects = (Object[]) result.get(i);
            t.getUionPK().setUser_id((String)objects[0]);
            t.getUionPK().setISBN((String)objects[1]);
            Timestamp timestamp = (Timestamp) objects[2];
            Date date = new Date(timestamp.getTime());
            t.setReturn_date(date);
            if (objects[3] != null) {
                timestamp = (Timestamp) objects[3];
                date = new Date(timestamp.getTime());
                t.setActual_date(date);
            }
            data[i] = t;
        }
        return data;
    }

    public Book queryBook(String ISBN) {
        String sql = "select * from BOOK where ISBN = '"+ ISBN +"'";
        List result = this.getHibernateDAO().findBySql(sql);
        if (result == null || result.isEmpty()){
            return null;
        }
        Book book = new Book();
        Object[] row =(Object[]) result.get(0);
        book.setBook_name((String)row[0]);
        book.setISBN((String) row[1]);
        book.setLang((String)row[2]);
        book.setAuthor((String)row[3]);
        book.setPress((String)row[4]);
        Timestamp timestamp = (Timestamp)row[5];
        book.setPub_year(timestamp.toString());;
        book.setAmount((Integer)row[6]);
        book.setRes_amount((Integer)row[7]);
        book.setTotal_amount((Integer)row[8]);
        book.setCall_no((String)row[9]);
        book.setPages((Integer)row[10]);
        book.setSize((Integer)row[11]);
        book.setCover((String)row[12]);
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
        String sql = "select * from RESERVATION where user_id = '"+ user_id +"'";
        List result = this.getHibernateDAO().findBySql(sql);
        if (result == null || result.isEmpty()){
            return null;
        }

        Reservation[] data = new Reservation[result.size()];
        for (int i=0; i<result.size(); i++){
            Reservation t = new Reservation();
            Object[] objects = (Object[]) result.get(i);
            t.getUionPK().setUser_id((String)objects[0]);
            t.getUionPK().setISBN((String)objects[1]);
            t.setStatus((Boolean) objects[2]);
            data[i] = t;
        }
        return data;
    }

    public Boolean add(String user_id,String ISBN)
    {
        Calendar temp = Calendar.getInstance().getInstance();
        temp.add(Calendar.MONTH,1);
        String date  = "{0}-{1}-{2}";
        date = date.replace("{0}",temp.get(Calendar.YEAR)+"");
        date = date.replace("{1}",temp.get(Calendar.MONTH)+1+"");
        date = date.replace("{2}",temp.get(Calendar.DAY_OF_MONTH)+"");
        String sql = "INSERT INTO BORROW_HISTORY (user_id, ISBN, return_date) VALUES ('"+user_id+"', '"+ISBN+"','"+date+"' );";
        try
        {
            this.getHibernateDAO().executeBySql(sql);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;

    }
    public String returnBook(String user_id,String ISBN)
    {

        String sql = "UPDATE BORROW_HISTORY SET actual_date = curdate() WHERE user_id = '"+user_id+"'AND ISBN = '"+ISBN+"'";
        try
        {
            this.getHibernateDAO().executeBySql(sql);
            return "return success";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "no record: wrong ISBN or ID";
        }
    }
}
