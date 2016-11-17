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

    public Book[] searchDistinctISBN(String keyword, String type) {
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
                t2.setISBN((String)row[0]);
                t2.setBook_name((String)row[1]);
                t2.setLang((String)row[2]);
                t2.setAuthor((String)row[3]);
                t2.setPress((String)row[4]);
                Timestamp trans = (Timestamp)row[5];
                t2.setPub_year(trans.toString().substring(0,4));
                t2.setCall_no((String)row[6]);
                t2.setPages((Integer)row[7]);
                t2.setSize((Integer)row[8]);
                t2.setCover((String)row[9]);
                books.add(t2);
            }
            Book[] fin = new Book[books.size()];
            fin = books.toArray(fin);
            return fin;
        }
    }


    private String concatSql(String keyword, String type){
        String sql = "SELECT DISTINCT(ISBN), book_name, lang, author, press, pub_year, call_no, pages, size, cover FROM BOOK WHERE ? ORDER BY pub_year DESC";
        String mySql = null;
        if (type.equals("Book Name")){
            String k = keyword.replace(' ','%');
            mySql = sql.replace("?", "book_name LIKE BINARY '%" + k + "%'");
        } else if (type.equals("Author")){
            String k = keyword.replace(' ','%');
            mySql = sql.replace("?", "author LIKE BINARY '%" + k + "%'");
        } else if (type.equals("ISBN")){
            mySql = sql.replace("?", "ISBN ='"+ keyword +"'");
        } else {
                System.out.println("Undefined Search Type!");
        }
        return mySql;
    }
}
