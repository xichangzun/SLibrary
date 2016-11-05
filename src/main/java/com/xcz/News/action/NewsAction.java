package com.xcz.News.action;

import com.alibaba.fastjson.JSONObject;
import com.xcz.News.Service.NewsService;
import com.xcz.News.domain.News;
import com.xcz.common.BaseAction;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by root on 16-11-4.
 */
public class NewsAction extends BaseAction {
    public NewsService getMynewservice() {
        return mynewservice;
    }

    public void setMynewservice(NewsService mynewservice) {
        this.mynewservice = mynewservice;
    }

    private NewsService mynewservice;

    public void add(){
        HttpServletRequest rq = ServletActionContext.getRequest();
        News news = new News();
        news.setTitle(rq.getParameter("title"));
        news.setSummary(rq.getParameter("summary"));
        news.setContent(rq.getParameter("content"));
        String result;
        if(this.getMynewservice().addNews(news)){
            result ="add success";
        }else {
            result = "add failed, try later";
        }
        JSONObject a = new JSONObject();
        a.put("message",result);
        HttpServletResponse rp = ServletActionContext.getResponse();
        rp.setContentType("text/html;charset=UTF8");
        try {
            rp.getWriter().append(a.toJSONString());
            rp.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(){
        HttpServletRequest rq = ServletActionContext.getRequest();
        News temp = new News();
        temp.setId((Integer) rq.getSession().getAttribute("new_id"));
        temp.setTitle(rq.getParameter("title"));
        temp.setSummary(rq.getParameter("summary"));
        temp.setContent(rq.getParameter("content"));

        String result;
        if(this.getMynewservice().updateNews(temp)){
            result ="update success";
        }else {
            result = "update failed, try later";
        }
        JSONObject a = new JSONObject();
        a.put("message",result);
        HttpServletResponse rp = ServletActionContext.getResponse();
        rp.setContentType("text/html;charset=UTF8");
        try {
            rp.getWriter().append(a.toJSONString());
            rp.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
