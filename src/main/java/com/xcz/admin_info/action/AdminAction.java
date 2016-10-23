package com.xcz.admin_info.action;

import com.xcz.admin_info.domain.Admin;
import com.xcz.admin_info.service.AdminService;
import com.xcz.common.BaseAction;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

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
        admin = this.getAdminService().check(id, pwd);
        if (admin == null) {
            rq.getSession().setAttribute("error", "ao");
            return ERROR;
        }
        rq.getSession().setAttribute("admin_name", admin.getUser_name());
        rq.getSession().setAttribute("admin_id", admin.getId());
        return SUCCESS;
    }
}
