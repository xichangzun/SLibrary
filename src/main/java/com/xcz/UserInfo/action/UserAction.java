package com.xcz.UserInfo.action;


import com.xcz.UserInfo.domain.UserInfo;
import com.xcz.UserInfo.service.LoginService;
import com.xcz.common.BaseAction;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by root on 16-10-7.
 */
public class UserAction extends BaseAction {
    private UserInfo xcz;
    private LoginService loginService;

    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginservice) {
        this.loginService = loginservice;
    }

    public String login() {
        HttpServletRequest rq = ServletActionContext.getRequest();
        String id = rq.getParameter("Username");
        String password = rq.getParameter("PWD");
        xcz = this.getLoginService().check(id, password);
        if (xcz == null) {
            rq.getSession().setAttribute("error", "ao");
            return ERROR;
        }
        System.out.print(SUCCESS);
        rq.getSession().setAttribute("user_name", xcz.getUser_name());
        rq.getSession().setAttribute("id", xcz.getId());
        rq.getSession().setAttribute("unit", xcz.getUnit());
        rq.getSession().setAttribute("email", xcz.getEmail());
        rq.getSession().setAttribute("tel", xcz.getTel());
        return SUCCESS;
    }

    public String logout() {
        HttpServletRequest rq = ServletActionContext.getRequest();
        HttpSession session = rq.getSession();
        if (session.getAttribute("id") != null) {
            session.removeAttribute("id");
        }
        if (session.getAttribute("error") != null) {
            session.removeAttribute("error");
        }
        if (session.getAttribute("user_name") != null) {
            session.removeAttribute("user_name");
        }
        if (session.getAttribute("unit") != null) {
            session.removeAttribute("unit");
        }
        if (session.getAttribute("email") != null) {
            session.removeAttribute("email");
        }
        if (session.getAttribute("tel") != null) {
            session.removeAttribute("tel");
        }
        return SUCCESS;
    }

    public String changePWD() {
        HttpServletRequest rq = ServletActionContext.getRequest();
        String checkpwd = (String) rq.getParameter("checkpwd");
        String new_password = (String) rq.getParameter("new_password");
        if (this.getLoginService().check(xcz.getId(), checkpwd) != null) {
            this.getLoginService().changePassWord(xcz.getId(), new_password);
            System.out.print("success");
            return SUCCESS;
        } else {
            System.out.print("wrong! Account is not exist");
            return ERROR;
        }
    }

    public String register(){
        HttpServletRequest rq = ServletActionContext.getRequest();
        String id = rq.getParameter("id");
        String pwd = rq.getParameter("pwd");
        String name = rq.getParameter("name");
        String unit = rq.getParameter("unit");
        String email = rq.getParameter("email");
        String tel = rq.getParameter("tel");
        UserInfo userInfo = new UserInfo(id, name, pwd, unit, email, tel);
        boolean status = this.getLoginService().register(userInfo);
        if (status){
            return SUCCESS;
        } else {
            return ERROR;
        }
    }
}
