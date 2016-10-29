package com.xcz.recommendation.action;

import com.xcz.borrow_history.domain.UionPK;
import com.xcz.common.BaseAction;
import com.xcz.recommendation.domain.Recommendation;
import com.xcz.recommendation.service.recommendService;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by root on 16-10-15.
 */
public class RecommendAction extends BaseAction {
    private recommendService service;
    private Recommendation recommendation;

    public recommendService getService() {
        return service;
    }

    public void setService(recommendService service) {
        this.service = service;
    }

    public String add()
    {
        HttpServletRequest rq = ServletActionContext.getRequest();
        HttpSession session = rq.getSession();
        recommendation = new Recommendation();
        String id = (String) session.getAttribute("id");
        String ISBN = rq.getParameter("ISBN");
        UionPK upk = new UionPK();
        upk.setISBN(ISBN);
        upk.setUser_id(id);
        recommendation.setUionPK(upk);
        recommendation.setBook_name(rq.getParameter("book_name"));
        recommendation.setLang(rq.getParameter("lang"));
        recommendation.setAuthor(rq.getParameter("author"));
        recommendation.setPress(rq.getParameter("press"));
        recommendation.setPrice(Float.parseFloat(rq.getParameter("price")));
        recommendation.setAmount(Integer.parseInt(rq.getParameter("amount")));
        recommendation.setReason(rq.getParameter("reason"));
        recommendation.setState("waiting");
        return this.getService().addrecommend(recommendation)?SUCCESS:ERROR;
    }
}
