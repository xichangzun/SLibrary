package com.xcz.ebook.action;

import com.xcz.common.BaseAction;
import com.xcz.ebook.domain.EBook;
import com.xcz.ebook.service.EBookService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


/**
 * Created by yhq on 2016/11/6.
 */
public class EBookAction extends BaseAction{
    private EBookService eBookService;

    public EBookService geteBookService() {
        return eBookService;
    }

    public void seteBookService(EBookService eBookService) {
        this.eBookService = eBookService;
    }

    public String search()
    {
        HttpServletRequest rq = ServletActionContext.getRequest();
        String keyword = rq.getParameter("keyword");
        String type = rq.getParameter("type");
        /*System.out.println("keyword is " + keyword);
        System.out.println("type is " + type);*/
        ArrayList<EBook> result = this.geteBookService().search(type, keyword);
        if(result.size()==0 || result== null) {
            System.out.print("error");
            rq.getSession().removeAttribute("ebook_result");
            return ERROR;
        }
        for(EBook ebook: result) {
            System.out.println(ebook.getEbook_name());
        }
        rq.getSession().setAttribute("ebook_result",result);
        return SUCCESS;
    }
}
