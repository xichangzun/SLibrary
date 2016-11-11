package com.xcz.News.Service;

import com.xcz.News.domain.News;
import com.xcz.common.BaseService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by root on 16-11-4.
 */
public class NewsServiceImpl extends BaseService implements NewsService {
    public Boolean addNews(News a){

        String sql = "INSERT INTO NEWS(title, summary, content, add_time) VALUES ('"+a.getTitle()+"','"+a.getSummary()+"','"+a.getContent()+"','"+getDate()+"')";
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
    public Boolean updateNews(News a){
        String sql = "UPDATE NEWS SET title = '"+a.getTitle()+"',summary ='"+a.getSummary()+"',content = '"+a.getContent()+"',add_time = '"+getDate()+"' WHERE id = "+a.getId()+"";
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

    private String getDate(){
        Calendar temp = Calendar.getInstance();
        String date  = "{0}-{1}-{2}";
        date = date.replace("{0}",temp.get(Calendar.YEAR)+"");
        date = date.replace("{1}",temp.get(Calendar.MONTH)+1+"");
        date = date.replace("{2}",temp.get(Calendar.DAY_OF_MONTH)+"");
        return date;
    }

    @Override
    public News[] query() {
        String sql = "SELECT * FROM NEWS ORDER BY add_time DESC LIMIT 5";
        List result = this.getHibernateDAO().findBySql(sql);
        if(result == null||result.isEmpty())
        {
            return null;
        }
        else
        {
            ArrayList<News> xcz =new ArrayList<News>();
            for(int i = 0;i<result.size();i++)
            {
                Object[] temp = (Object[]) result.get(i);
                News t2 = new News();
                t2.setId((Integer)temp[0]);
                t2.setTitle((String)temp[1]);
                t2.setSummary((String)temp[2]);
                t2.setContent((String)temp[3]);
                xcz.add(t2);
            }
            News[] fin = new News[xcz.size()];
            fin = xcz.toArray(fin);
            return fin;
        }
    }

    public News[] res_query(){
        String sql = "SELECT * FROM UPRECORD ORDER BY add_time DESC LIMIT 6";
        List result = this.getHibernateDAO().findBySql(sql);
        if(result == null||result.isEmpty())
        {
            return null;
        }
        else
        {
            ArrayList<News> xcz =new ArrayList<News>();
            for(int i = 0;i<result.size();i++)
            {
                Object[] temp = (Object[]) result.get(i);
                News t2 = new News();
                t2.setId((Integer)temp[0]);
                t2.setSummary((String)temp[1]);
                t2.setTitle((String)temp[2]);
                xcz.add(t2);
            }
            News[] fin = new News[xcz.size()];
            fin = xcz.toArray(fin);
            return fin;
        }
    }
}
