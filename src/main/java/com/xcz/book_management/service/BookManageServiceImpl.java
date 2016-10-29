package com.xcz.book_management.service;

import com.mchange.v2.async.StrandedTaskReporting;
import com.xcz.common.BaseService;
import com.xcz.search.domain.Book;

/**
 * Created by yhq on 2016/10/24.
 */
public class BookManageServiceImpl extends BaseService implements BookManageService {
    public Boolean addBook(Book a)
    {
        String sql = "INSERT INTO book(ISBN,book_name,lang,author,press,pub_year,amount,res_amount,total_amount,call_no,pages,size,cover) " +
                "VALUES ('"+a.getISBN()+"','"+a.getBook_name()+"','"+a.getLang()+"','"+a.getAuthor()+"','"+a.getPress()+"',"+a.getPub_year()+",{6},{7},{8},'"+a.getCall_no()+"',{10},{11},'"+a.getCover()+"')";
        sql = sql.replace("{6}",a.getAmount()+"");
        sql = sql.replace("{7}",a.getRes_amount()+"");
        sql = sql.replace("{8}",a.getTotal_amount()+"");
        sql = sql.replace("{10}",a.getPages()+"");
        sql = sql.replace("{11}",a.getSize()+"");
        try
        {
            this.getHibernateDAO().executeBySql(sql);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delBook(String ISBN)
    {
        String sql = "DELETE  FROM book WHERE  ISBN = '"+ISBN+"' ";
        try
        {
            return !this.getHibernateDAO().executeBySql(sql);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
