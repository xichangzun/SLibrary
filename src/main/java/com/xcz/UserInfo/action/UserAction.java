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
        Double fine = loginService.getFine(id);
        rq.getSession().setAttribute("fine", fine.toString());
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
        if (session.getAttribute("fine") != null) {
            session.removeAttribute("fine");
        }
        return SUCCESS;
    }

    public String changePWD() {
        HttpServletRequest rq = ServletActionContext.getRequest();
        String checkpwd = (String) rq.getParameter("checkpwd");
        String new_password = (String) rq.getParameter("new_password");
        String msg;
        // 检测用户密码
        if (this.getLoginService().check(xcz.getId(), checkpwd) != null) {
            if (this.getLoginService().changePassWord(xcz.getId(), new_password))
                msg = "You password changed success!";
            else
                msg = "Change password failed!";
        } else {
            msg = "Please check you old password!";
        }
        setAjaxResponse("text/html;charset=UTF8", msg);
        return msg;
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
            setAjaxResponse("text/html;charset=UTF8", SUCCESS);
            return SUCCESS;
        } else {
            setAjaxResponse("text/html;charset=UTF8", ERROR);
            return ERROR;
        }
    }

    public void ajaxlogin(){
        HttpServletRequest rq = ServletActionContext.getRequest();
        String id = rq.getParameter("Username");
        String password = rq.getParameter("PWD");
        xcz = this.getLoginService().check(id, password);
        if (xcz == null) {
            rq.getSession().setAttribute("error", "ao");
        }
        System.out.print(SUCCESS);

        rq.getSession().setAttribute("user_name", xcz.getUser_name());
        rq.getSession().setAttribute("id", xcz.getId());
        rq.getSession().setAttribute("unit", xcz.getUnit());
        rq.getSession().setAttribute("email", xcz.getEmail());
        rq.getSession().setAttribute("tel", xcz.getTel());
        Double fine = loginService.getFine(id);
        rq.getSession().setAttribute("fine", fine.toString());
        setAjaxResponse("text/html;charset=UTF8","login success");
    }
}
