package com.xcz.book_management.service;

import com.xcz.common.BaseService;
import com.xcz.search.domain.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by yhq on 2016/10/24.
 */
public class BookManageServiceImpl extends BaseService implements BookManageService {
    public Boolean addBook(Book a) {
        String sql = "INSERT INTO BOOK(id,ISBN,book_name,lang,author,press,pub_year,call_no,state,pages,size,cover) " +
                "VALUES ('"+a.getId()+"','"+a.getISBN()+"','"+a.getBook_name()+"','"+a.getLang()+"','"+a.getAuthor()+"'," +
                "'"+a.getPress()+"',"+a.getPub_year()+",'"+a.getCall_no()+"','"+a.getState()+"',"+a.getPages()+","+a.getSize()+", '"+a.getCover()+"')";
        System.out.print(sql);
        return this.getHibernateDAO().executeBySql(sql);
    }

    public Boolean delBookByISBN(String ISBN) {
        String sql = "DELETE FROM BOOK WHERE ISBN = '"+ISBN+"'";
        return this.getHibernateDAO().updateBySql(sql)!=0;
    }

    @Override
    public Boolean delBookById(String id) {
        String sql = "DELETE FROM BOOK WHERE id = '"+id+"'";
        return this.getHibernateDAO().updateBySql(sql)!=0;
    }

    @Override
    public int getBookCount(String ISBN) {
        String sql = "SELECT COUNT(*) FROM BOOK WHERE ISBN = '" + ISBN + "'";
        int cnt;
        Connection connection = this.getHibernateDAO().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            cnt = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            // 出错时返回-1
            cnt = -1;
        }
        return cnt;
    }

    @Override
    public Boolean Insert(String book_name){
        String sql = "INSERT into UPRECORD (type, title, add_time)VALUE ('BOOK','"+book_name+"',sysdate())";
        return this.getHibernateDAO().executeBySql(sql);
    }
}
