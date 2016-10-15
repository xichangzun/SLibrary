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
        String para = rq.getParameter("request");
        Book[] result = this.getSearchService().search(para);
        if(result == null || result.length == 0)
        {
            System.out.print("error");
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
