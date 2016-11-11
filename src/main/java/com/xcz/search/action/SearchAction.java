package com.xcz.search.action;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xcz.common.BaseAction;
import com.xcz.search.domain.Book;
import com.xcz.search.service.SearchService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by root on 16-10-8.
 */
public class SearchAction extends BaseAction {
    public SearchService getSearchService() {
        return searchService;
    }

    public void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }

    private SearchService searchService;

    public String Search()
    {
        HttpServletRequest rq = ServletActionContext.getRequest();
        String keyword = rq.getParameter("keyword");
        String type = rq.getParameter("type");
        /*System.out.println("keyword is " + keyword);
        System.out.println("type is " + type);*/
        Book[] result = this.getSearchService().search(keyword, type);
        if(result == null || result.length == 0)
        {
            System.out.print("error");
            rq.getSession().removeAttribute("result");
            return ERROR;
        }
        for(int i = 0;i<result.length;i++)
        {
            System.out.println(result[i].getBook_name());
        }
        rq.getSession().setAttribute("result",result);
        return SUCCESS;
    }

    public void SearchForAjax(){
        HttpServletRequest rq = ServletActionContext.getRequest();
        String keyword = rq.getParameter("keyword");
        String type = rq.getParameter("type");
        Book[] result = this.getSearchService().search(keyword, type);
        JSONArray back = new JSONArray();
        if(result != null && result.length > 0){
            for (Book a : result){
                JSONObject temp = new JSONObject();
                temp.put("cover",a.getCover());
                temp.put("title",a.getBook_name());
                temp.put("author",a.getAuthor());
                temp.put("press",a.getPress());
                temp.put("call_no",a.getCall_no());
                temp.put("pub_year",a.getPub_year());
                back.add(temp);
            }
        }
        HttpServletResponse rp = ServletActionContext.getResponse();
        rp.setContentType("application/json;charset=UTF8");
        try {
            rp.getWriter().append(back.toJSONString());
            rp.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
