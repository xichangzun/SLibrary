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

    public Book[] search(String keyword, String type) {
        String sql = concatSql(keyword, type);
        List result = this.getHibernateDAO().findBySql(sql);
        if(result == null||result.isEmpty()) {
            return null;
        }
        else {
            ArrayList<Book> books =new ArrayList<Book>();
            for(int i = 0;i<result.size();i++) {
                Object[] row = (Object[]) result.get(i);
                Book t2 = new Book();
                t2.setId((String)row[0]);
                t2.setISBN((String)row[1]);
                t2.setBook_name((String)row[2]);
                t2.setLang((String)row[3]);
                t2.setAuthor((String)row[4]);
                t2.setPress((String)row[5]);
                Timestamp trans = (Timestamp)row[6];
                t2.setPub_year(trans.toString().substring(0,4));
                t2.setCall_no((String)row[7]);
                t2.setState((String)row[8]);
                t2.setPages((Integer)row[9]);
                t2.setSize((Integer)row[10]);
                t2.setCover((String)row[11]);
                books.add(t2);
            }
            Book[] fin = new Book[books.size()];
            fin = books.toArray(fin);
            return fin;
        }
    }

    private String concatSql(String keyword, String type){
        String sql = null;
        if (type.equals("Book Name")){
            String k = keyword.replace(' ','%');
            sql = "SELECT * FROM BOOK WHERE book_name LIKE BINARY '%" + k + "%' ORDER BY pub_year DESC";
        } else if (type.equals("Author")){
            String k = keyword.replace(' ','%');
            sql = "SELECT * FROM BOOK WHERE author LIKE BINARY '%" + k + "%' ORDER BY pub_year DESC";
        } else if (type.equals("ISBN")){
            sql = "SELECT * FROM BOOK WHERE ISBN = '"+ keyword + "' ORDER BY pub_year DESC";
        } else {
            System.out.println("Undefined Type!");
        }
        return sql;
    }
}
