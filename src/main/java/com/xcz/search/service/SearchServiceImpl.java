package com.xcz.search.service;

import com.xcz.common.BaseService;
import com.xcz.search.domain.Book;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 16-10-9.
 */
public class SearchServiceImpl extends BaseService implements SearchService {
    public Book[] search(String para)
    {
        String a = para.replace(' ','%');
        String sql = "SELECT * FROM BOOK WHERE book_name LIKE BINARY '%"+a+"%' ";
        List result = this.getHibernateDAO().findBySql(sql);
        if(result == null||result.isEmpty())
        {
            return null;
        }
        else
        {
            ArrayList<Book> xcz =new ArrayList<Book>();
            for(int i = 0;i<result.size();i++)
            {
                Object[] temp = (Object[]) result.get(i);
                Book t2 = new Book();
                t2.setBook_name((String)temp[0]);
                t2.setISBN((String) temp[1]);
                t2.setLang((String)temp[2]);
                t2.setAuthor((String)temp[3]);
                t2.setPress((String)temp[4]);
                Timestamp trans = (Timestamp)temp[5];
                t2.setPub_year(trans.toString());;
                t2.setAmount((Integer)temp[6]);
                t2.setRes_amount((Integer)temp[7]);
                t2.setTotal_amount((Integer)temp[8]);
                t2.setCall_no((String)temp[9]);
                t2.setPages((Integer)temp[10]);
                t2.setSize((Integer)temp[11]);
                t2.setCover((String)temp[12]);
                xcz.add(t2);
            }
            Book[] fin = new Book[xcz.size()];
            fin = xcz.toArray(fin);
            return fin;
        }

    }
}
