package com.xcz.book_management.action;

import com.xcz.book_management.service.BookManageService;
import com.xcz.common.BaseAction;
import com.xcz.search.domain.Book;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yhq on 2016/10/24.
 */
public class BookManageAction extends BaseAction {
    private BookManageService bookManageService;

    public BookManageService getBookManageService() {
        return bookManageService;
    }

    public void setBookManageService(BookManageService bookManageService) {
        this.bookManageService = bookManageService;
    }

    public String addBook()
    {
        HttpServletRequest rq = ServletActionContext.getRequest();
        Book a = new Book();
        a.setISBN(rq.getParameter("ISBN"));
        a.setBook_name(rq.getParameter("Book_name"));
        a.setAuthor(rq.getParameter("author"));
        a.setLang(rq.getParameter("lang"));
        a.setPress(rq.getParameter("press"));
        a.setPub_year(rq.getParameter("pub_year"));
        a.setTotal_amount(Integer.parseInt(rq.getParameter("total_amount")));
        a.setCall_no(rq.getParameter("call_no"));
        String aa = rq.getParameter("pages");
        if(!aa.isEmpty())
            a.setPages(Integer.parseInt(aa));
        aa = rq.getParameter("size");
        if (!aa.isEmpty())
            a.setSize(Integer.parseInt(aa));
        a.setRes_amount(0);
        a.setAmount(a.getTotal_amount());
        aa = rq.getParameter("cover");
        if (aa.isEmpty())
            aa = "/pictures/default.jpg";
        a.setCover(aa);
        if(this.getBookManageService().addBook(a))
            return SUCCESS;
        else
            return ERROR;
    }
    public String delBook()
    {
        HttpServletRequest rq = ServletActionContext.getRequest();
        if(this.getBookManageService().delBook(rq.getParameter("keyword")))
            return SUCCESS;
        else
            return ERROR;
    }
}
