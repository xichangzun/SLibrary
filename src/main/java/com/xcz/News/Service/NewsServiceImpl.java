package com.xcz.News.Service;

import com.xcz.News.domain.News;
import com.xcz.common.BaseService;

import java.util.Calendar;

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
}
