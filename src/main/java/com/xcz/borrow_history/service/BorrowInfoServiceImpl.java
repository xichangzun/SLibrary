package com.xcz.borrow_history.service;

import com.xcz.borrow_history.domain.BorrowHistory;
import com.xcz.borrow_history.domain.Reservation;
import com.xcz.common.BaseService;
import com.xcz.search.domain.Book;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
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
}
