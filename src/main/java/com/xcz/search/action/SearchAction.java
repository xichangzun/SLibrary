package com.xcz.search.action;

import com.xcz.common.BaseAction;
import com.xcz.search.domain.Book;
import com.xcz.search.service.SearchService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

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
}
