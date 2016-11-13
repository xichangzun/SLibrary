package com.xcz.News.action;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xcz.News.Service.NewsService;
import com.xcz.News.domain.News;
import com.xcz.common.BaseAction;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

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
        News temp = (News) rq.getSession().getAttribute("news_item");
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

    public String query(){
        HttpServletRequest rq = ServletActionContext.getRequest();
        News[] xcz = this.getMynewservice().query();
        rq.getSession().setAttribute("news_array",xcz);
        return SUCCESS;
    }

    public String detail(){
        HttpServletRequest rq = ServletActionContext.getRequest();
        int id = Integer.parseInt(rq.getParameter("index")) ;
        News[] xcz= (News[]) rq.getSession().getAttribute("news_array");
        for(News news_item : xcz){
            int temp = news_item.getId();
            if(temp == id ){
                rq.getSession().setAttribute("news_item",news_item);
                return SUCCESS;
            }
        }
        return ERROR;
    }

    public void callback(){
        query();
        News[] xcz= (News[]) ServletActionContext.getRequest().getSession().getAttribute("news_array");
        JSONArray result = new JSONArray();
        if(xcz != null){
            for(News news_item :xcz){
                JSONObject a = new JSONObject();
                a.put("id",news_item.getId());
                a.put("title",news_item.getTitle());
                a.put("summary",news_item.getSummary());
                result.add(a);
            }
        }
        HttpServletResponse rp = ServletActionContext.getResponse();
        rp.setContentType("application/json;charset=UTF8");
        try {
            rp.getWriter().append(result.toJSONString());
            rp.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void callres(){
        News[] xcz = this.getMynewservice().res_query();
        JSONArray result = new JSONArray();
        if(xcz != null){
            for(News news_item :xcz){
                JSONObject a = new JSONObject();
                a.put("type",news_item.getSummary());
                a.put("title",news_item.getTitle());
                result.add(a);
            }
        }
        HttpServletResponse rp = ServletActionContext.getResponse();
        rp.setContentType("application/json;charset=UTF8");
        try {
            rp.getWriter().append(result.toJSONString());
            rp.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void delete(){
        HttpServletRequest rq = ServletActionContext.getRequest();
        int id = Integer.parseInt(rq.getParameter("index")) ;
        setAjaxResponse("text/html;charset=UTF8",this.getMynewservice().delete(id)?SUCCESS:ERROR);
    }
}
