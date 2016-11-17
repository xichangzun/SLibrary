package com.xcz.book_management.action;

import com.xcz.book_management.service.BookManageService;
import com.xcz.common.BaseAction;
import com.xcz.common.ImageCompressUtil;
import com.xcz.constant.MyConstant;
import com.xcz.search.domain.Book;
import com.xcz.search.service.SearchService;
import com.xcz.search.service.SearchServiceImpl;
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

    private String saveCover(String ISBN) {
        if (cover == null)
            return "pictures/default.jpg";
        else {
            String suffix = getSuffix(cover.getName());
            String path = ServletActionContext.getServletContext().getRealPath("/pictures");
            String fileName = ISBN + suffix;
            try {
                FileUtils.copyFile(cover, new File(path, fileName));
                FileUtils.copyFile(cover, new File(MyConstant.YHQ_PICTURE_PATH, fileName));
                // 压缩图片
                ImageCompressUtil.zipImageFile(path + "\\" + fileName, 107, 153, 0.8f, "");
                ImageCompressUtil.zipImageFile(MyConstant.YHQ_PICTURE_PATH + "/" + fileName, 107, 153, 0.8f, "");
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
        int amount = Integer.parseInt(rq.getParameter("amount"));
        int cnt = bookManageService.getBookCount(a.getISBN());
        if (cnt == -1){
            setAjaxResponse("text/html;charset=UTF8",ERROR);
            return ERROR;
        }
        a.setBook_name(rq.getParameter("name"));
        a.setAuthor(rq.getParameter("author"));
        a.setLang(rq.getParameter("lang"));
        a.setPress(rq.getParameter("press"));
        a.setPub_year(rq.getParameter("pub_year"));
        a.setCall_no(rq.getParameter("call_no"));
        // 刚加入书的时候为Available
        a.setState("Available");
        String t = rq.getParameter("pages");
        if (!t.isEmpty())
            a.setPages(Integer.parseInt(t));
        t = rq.getParameter("size");
        if (!t.isEmpty())
            a.setSize(Integer.parseInt(t));
        t = saveCover(a.getISBN());
        if (t.contentEquals("false")){
            setAjaxResponse("text/html;charset=UTF8",ERROR);
            return ERROR;
        }
        a.setCover(t);
        //每本书一个id
        try{
            for (int i=cnt+1; i<=cnt+amount; i++){
                a.setId(a.getISBN() + i);
                bookManageService.addBook(a);
            }
        } catch (Exception e){
            e.printStackTrace();
            setAjaxResponse("text/html;charset=UTF8", ERROR);
            return ERROR;
        }
        this.getBookManageService().Insert(a.getBook_name());
        setAjaxResponse("text/html;charset=UTF8", SUCCESS);
        return SUCCESS;
    }

    public String delBook() {
        HttpServletRequest rq = ServletActionContext.getRequest();
        String input = rq.getParameter("ISBN");
        String msg;
        try{
            Boolean isDelete = bookManageService.delBookByISBN(input);
            if (isDelete)
                msg = "Delete Success!";
            else
                msg = "Noting is delete, please ensure ISBN is correct!";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "You can't delete this ISBN, because it have record in the system! ";
        }
        setAjaxResponse("text/html;charset=UTF8", msg);
        return msg;
    }

    // 动态生成书的表格
    public String reserve(){
        HttpServletRequest rq = ServletActionContext.getRequest();
        String ISBN = rq.getParameter("ISBN");
        Book[] xcz = bookManageService.searchAll(ISBN);
        rq.getSession().setAttribute("all_isbn", xcz);
        return SUCCESS;
    }

    public void ajaxRes(){
        HttpServletRequest rq = ServletActionContext.getRequest();
        int id = Integer.parseInt(rq.getParameter("id")) ;
        String user_id = (String)rq.getSession().getAttribute("id");
        if(user_id == null){
            setAjaxResponse("text/html;charset=UTF8","please login first");
        }
        else {
            String msg = bookManageService.InsertRes(user_id, id+"");
            setAjaxResponse("text/html;charset=UTF8",msg);
        }

    }

    private void delFile(String ISBN){
        String path = ServletActionContext.getServletContext().getRealPath("/pictures");
        FileUtils.deleteQuietly(new File(path + "\\" + ISBN + ".jpg"));
        FileUtils.deleteQuietly(new File(MyConstant.YHQ_PICTURE_PATH + "/" + ISBN + ".jpg"));
    }

    private String getSuffix(String name){
        return name.substring(name.indexOf("."), name.length());
    }

}
