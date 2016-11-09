package com.xcz.ebook.service;

import com.xcz.common.BaseService;
import com.xcz.ebook.domain.EBook;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhq on 2016/11/6.
 */
public class EBookServiceImpl extends BaseService implements EBookService {
    @Override
    public ArrayList<EBook> search(String type, String keyword) {
        String sql = concatSql(type, keyword);
        List result = this.getHibernateDAO().findBySql(sql);
        if(result == null||result.isEmpty()) {
            return null;
        } else {
            ArrayList<EBook> ebooks = new ArrayList<>();
            for(int i=0; i<result.size(); i++){
                Object[] row = (Object[]) result.get(i);
                EBook ebook = new EBook();
                ebook.setEbook_name((String)row[0]);
                ebook.setAuthor((String)row[1]);
                ebook.setISBN((String)row[2]);
                ebook.setLang((String)row[3]);
                ebook.setPress((String)row[4]);
                Timestamp timestamp = (Timestamp)row[5];
                ebook.setPub_year(timestamp.toString().substring(0,4));
                ebook.setPages((Integer)row[6]);
                ebook.setCover((String)row[7]);
                ebook.setPdf((String)row[8]);
                ebooks.add(ebook);
            }
            return ebooks;
        }
    }

    private String concatSql(String type, String keyword){
        String sql = null;
        if (type.equals("E-Res Name")){
            String k = keyword.replace(' ','%');
            sql = "SELECT * FROM EBOOK WHERE ebook_name LIKE BINARY '%" + k + "%' ORDER BY pub_year DESC";
        } else if (type.equals("Author")){
            String k = keyword.replace(' ','%');
            sql = "SELECT * FROM EBOOK WHERE author LIKE BINARY '%" + k + "%' ORDER BY pub_year DESC";
        } else {
            System.out.println("Undefined Type!");
        }
        return sql;
    }
}
