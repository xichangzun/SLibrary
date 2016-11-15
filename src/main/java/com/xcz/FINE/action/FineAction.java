package com.xcz.FINE.action;

import com.xcz.FINE.service.FineService;
import com.xcz.common.BaseAction;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by root on 16-11-12.
 */
public class FineAction extends BaseAction {
    private FineService myFineService;

    public FineService getMyFineService() {
        return myFineService;
    }

    public void setMyFineService(FineService myFineService) {
        this.myFineService = myFineService;
    }

    public Double getBill(String id){
        return this.getMyFineService().queryAll(id);
    }

    public Double getFine(String id){
        return this.getMyFineService().query(id);
    }

    //查询罚款
    public void FineCallBack(){
        HttpServletRequest rq = ServletActionContext.getRequest();
        String id = rq.getParameter("id");
        Double fine = getFine(id);
        HttpServletResponse rp = ServletActionContext.getResponse();
        rp.setContentType("text/html;charset=UTF8");
        try {
            rp.getWriter().append(fine+"");
            rp.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //更新罚款
    public void Update(){
        HttpServletRequest rq = ServletActionContext.getRequest();
        String id = rq.getParameter("id");
        String message;
        if(this.getMyFineService().Update(id)){
            message = "clear fine success!";
        }
        else {
            message = "clear fine failed, please try later!";
        }
        HttpServletResponse rp = ServletActionContext.getResponse();
        rp.setContentType("text/html;charset=UTF8");
        try {
            rp.getWriter().append(message);
            rp.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
