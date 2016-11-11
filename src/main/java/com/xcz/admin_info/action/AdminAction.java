package com.xcz.admin_info.action;

import com.xcz.admin_info.domain.Admin;
import com.xcz.admin_info.service.AdminService;
import com.xcz.common.BaseAction;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yhq on 2016/10/23.
 */
public class AdminAction extends BaseAction{
    private Admin admin;
    private AdminService adminService;

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public String login() {
        HttpServletRequest rq = ServletActionContext.getRequest();
        String id = rq.getParameter("id");
        String pwd = rq.getParameter("pwd");
        admin = this.getAdminService().login(id, pwd);
        if (admin == null) {
            rq.getSession().removeAttribute("admin");
            setAjaxResponse("text/html;charset=UTF8", ERROR);
            return ERROR;
        }
        rq.getSession().setAttribute("admin", admin);
        setAjaxResponse("text/html;charset=UTF8", SUCCESS);
        return SUCCESS;
    }
}
