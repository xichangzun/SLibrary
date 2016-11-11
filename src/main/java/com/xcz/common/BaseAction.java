package com.xcz.common;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by root on 16-10-6.
 */
public class BaseAction extends ActionSupport{
    public void setAjaxResponse(String contentType, String data){
        HttpServletResponse rp = ServletActionContext.getResponse();
        rp.setContentType(contentType);
        try{
            rp.getWriter().append(data);
            rp.getWriter().close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
