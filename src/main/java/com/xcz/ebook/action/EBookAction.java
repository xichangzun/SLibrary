package com.xcz.ebook.action;

import com.sun.org.apache.bcel.internal.generic.I2F;
import com.xcz.common.BaseAction;
import com.xcz.common.ImageCompressUtil;
import com.xcz.constant.MyConstant;
import com.xcz.ebook.domain.EBook;
import com.xcz.ebook.service.EBookService;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Created by yhq on 2016/11/6.
 */
public class EBookAction extends BaseAction{
    private EBookService eBookService;
    private File cover;
    private File pdf;

    public File getCover() {
        return cover;
    }

    public void setCover(File cover) {
        this.cover = cover;
    }

    public File getPdf() {
        return pdf;
    }

    public void setPdf(File pdf) {
        this.pdf = pdf;
    }

    public EBookService geteBookService() {
        return eBookService;
    }

    public void seteBookService(EBookService eBookService) {
        this.eBookService = eBookService;
    }

    public String search() {
        HttpServletRequest rq = ServletActionContext.getRequest();
        String keyword = rq.getParameter("keyword");
        String type = rq.getParameter("type");
        /*System.out.println("keyword is " + keyword);
        System.out.println("type is " + type);*/
        ArrayList<EBook> result = this.geteBookService().search(type, keyword);
        if(result== null || result.size()==0) {
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

    public String add(){
        HttpServletRequest rq = ServletActionContext.getRequest();
        EBook a = new EBook();
        String t;
        a.setISBN(rq.getParameter("ISBN"));
        a.setEbook_name(rq.getParameter("name"));
        a.setAuthor(rq.getParameter("author"));
        a.setLang(rq.getParameter("lang"));
        a.setPress(rq.getParameter("press"));
        a.setPub_year(rq.getParameter("pub_year"));
        if (!rq.getParameter("pages").isEmpty())
            a.setPages(Integer.parseInt(rq.getParameter("pages")));
        t = saveCover(a.getISBN());
        if (t.contentEquals("false")) {
            setAjaxResponse("text/html;charset=UTF8", ERROR);
            return ERROR;
        }
        a.setCover(t);
        t = savePdf(a.getISBN());
        if (t.contentEquals("false")) {
            setAjaxResponse("text/html;charset=UTF8", ERROR);
            return ERROR;
        }
        a.setPdf(t);
       try{
           eBookService.add(a);
        } catch (Exception e){
            e.printStackTrace();
            setAjaxResponse("text/html;charset=UTF8", ERROR);
            return ERROR;
        }
        setAjaxResponse("text/html;charset=UTF8", SUCCESS);
        return SUCCESS;
    }

    public String delete(){
        HttpServletRequest rq = ServletActionContext.getRequest();
        String isbn = rq.getParameter("ISBN");
        Boolean isDelete = eBookService.delete(isbn);
        deleteFile(isbn);
        if (isDelete)
            setAjaxResponse("text/html;charset=UTF8", SUCCESS);
        else
            setAjaxResponse("text/html;charset=UTF8", ERROR);
        return SUCCESS;
    }

    private void deleteFile(String isbn){
        String path = ServletActionContext.getServletContext().getRealPath("/");
        FileUtils.deleteQuietly(new File(path + "\\pictures\\e_" + isbn + ".jpg"));
        FileUtils.deleteQuietly(new File(MyConstant.YHQ_PICTURE_PATH + "/e_" + isbn + ".jpg"));
        FileUtils.deleteQuietly(new File(path + "\\pdf\\" + isbn + ".pdf"));
        FileUtils.deleteQuietly(new File(MyConstant.YHQ_PDF_PATH + "/" + isbn + ".pdf"));
    }

    private String savePdf(String ISBN) {
        if (pdf == null)
            return "false";
        else {
            String path = ServletActionContext.getServletContext().getRealPath("/pdf");
            String fileName = ISBN + ".pdf";
            try {
                FileUtils.copyFile(pdf, new File(path, fileName));
                FileUtils.copyFile(pdf, new File(MyConstant.YHQ_PDF_PATH, fileName));
            } catch (IOException e) {
                return "false";
            }
            return "pdf/" + fileName;
        }
    }

    private String saveCover(String ISBN) {
        if (cover == null)
            return "pictures/e_default.jpg";
        else {
            String suffix = getSuffix(cover.getName());
            String path = ServletActionContext.getServletContext().getRealPath("/pictures");
            String fileName = "e_" + ISBN + suffix;
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

    private String getSuffix(String name){
        return name.substring(name.indexOf("."), name.length());
    }

}
