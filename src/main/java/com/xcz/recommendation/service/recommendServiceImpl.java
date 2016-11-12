package com.xcz.recommendation.service;

import com.xcz.common.BaseService;
import com.xcz.recommendation.domain.RecomUionPK;
import com.xcz.recommendation.domain.Recommendation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.xcz.constant.MyConstant.UNHANDLE;

/**
 * Created by root on 16-10-15.
 */
public class recommendServiceImpl extends BaseService implements recommendService {
    public Boolean addrecommend(Recommendation a) {
        String sql = "INSERT INTO RECOMMENDATION (user_id, ISBN, book_name, lang, author, press,  price, amount, reason, state)" +
                "  VALUE ('"+a.getUionPK().getUser_id()+"','"+a.getUionPK().getISBN()+"','"
        +a.getBook_name()+"','"+a.getLang()+"','"+a.getAuthor()+"','"+a.getPress()+"',{6},{7},'"+a.getReason()+"','"+a.getState()+"')";
        sql = sql.replace("{6}",a.getPrice().toString());
        sql = sql.replace(("{7}"),a.getAmount().toString());
        System.out.println(sql);
        return this.getHibernateDAO().executeBySql(sql);
    }

    @Override
    public int getPageCount(int pagesize, String type) {
        String sql;
        int cnt, r;
        if ("unhandle".equals(type))
            sql = "SELECT COUNT(*) FROM RECOMMENDATION WHERE state = '" + UNHANDLE + "'";
        else
            sql = "SELECT COUNT(*) FROM RECOMMENDATION WHERE state <> '" + UNHANDLE + "'";
        Connection connection = this.getHibernateDAO().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            cnt = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            cnt = 0;
        }
        r = (cnt % pagesize == 0)? 0: 1;
        return cnt/pagesize + r;
    }

    @Override
    public ArrayList<Recommendation> get(int page, int pagesize, String type) {
        String sql;
        if ("unhandle".equals(type))
            sql = "SELECT * FROM RECOMMENDATION WHERE state = '" + UNHANDLE + "' LIMIT " + (page-1)*pagesize + "," + pagesize;
        else if ("handled".equals(type))
            sql = "SELECT * FROM RECOMMENDATION WHERE state <> '"+ UNHANDLE + "' LIMIT " + (page-1)*pagesize + "," + pagesize;
        else
            sql = "SELECT * FROM RECOMMENDATION LIMIT " + (page-1)*pagesize + "," + pagesize;
        List result = this.getHibernateDAO().findBySql(sql);
        if (result == null || result.size()==0)
            return null;
        ArrayList<Recommendation> data = new ArrayList<>();
        for(int i=0; i<result.size(); i++){
            Recommendation recom = new Recommendation();
            Object[] row = (Object[]) result.get(i);
            RecomUionPK uionPK = new RecomUionPK();
            uionPK.setUser_id((String)row[0]);
            uionPK.setISBN((String)row[5]);
            recom.setUionPK(uionPK);
            recom.setBook_name((String)row[1]);
            recom.setLang((String)row[2]);
            recom.setAuthor((String)row[3]);
            recom.setPress((String)row[4]);
            recom.setPrice((float)row[6]);
            recom.setAmount((Integer)row[7]);
            recom.setReason((String)row[8]);
            recom.setState((String)row[9]);
            data.add(recom);
        }
        return data;
    }

    @Override
    public Boolean handleRecom(String id, String isbn, String state) {
        String sql = "UPDATE RECOMMENDATION SET state = '" + state + "' WHERE user_id = '" + id + "' AND ISBN = '" + isbn + "'";
        return this.getHibernateDAO().executeBySql(sql);
    }

    @Override
    public Boolean delete(String id, String isbn) {
        String sql = "DELETE FROM RECOMMENDATION WHERE user_id = '"+id+"' AND ISBN = '"+isbn+"'";
        return this.getHibernateDAO().executeBySql(sql);
    }

}
