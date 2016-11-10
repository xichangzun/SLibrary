package com.xcz.book_management.action;

import com.xcz.book_management.service.BookManageService;
import com.xcz.common.BaseAction;
import com.xcz.search.domain.Book;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by yhq on 2016/10/24.
 */
public class BookManageAction extends BaseAction {
    private BookManageService bookManageService;

    private File cover;

    public File getCover() {
        return cover;
    }

    public void setCover(File cover) {
        this.cover = cover;
    }


    public BookManageService getBookManageService() {
        return bookManageService;
    }

    public void setBookManageService(BookManageService bookManageService) {
        this.bookManageService = bookManageService;
    }

    private String SavePhoto(String ISBN) {
        if (cover == null)
            return "pictures/default.jpg";
        else {
            String path = ServletActionContext.getServletContext().getRealPath("/pictures");
            System.out.println(path);
            String fileName = ISBN + ".jpg";
            try {
                FileUtils.copyFile(cover, new File(path, fileName));
                FileUtils.copyFile(cover, new File("/home/xichangzun/SLibrary/SLibrary/src/main/webapp/pictures", fileName));

            } catch (IOException e) {
                return "false";
            }

            return "pictures/" + fileName;
        }
    }

    public String addBook() {
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
        if (!aa.isEmpty())
            a.setPages(Integer.parseInt(aa));
        aa = rq.getParameter("size");
        if (!aa.isEmpty())
            a.setSize(Integer.parseInt(aa));
        a.setRes_amount(0);
        a.setAmount(a.getTotal_amount());
        aa = SavePhoto(a.getISBN());
        if (aa.contentEquals("false")) return ERROR;
        a.setCover(aa);
        if (this.getBookManageService().addBook(a))
            return SUCCESS;
        else
            return ERROR;
    }

    public String delBook() {
        HttpServletRequest rq = ServletActionContext.getRequest();
        if (this.getBookManageService().delBook(rq.getParameter("keyword")))
            return SUCCESS;
        else
            return ERROR;
    }
}
