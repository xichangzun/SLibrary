package com.xcz.recommendation.action;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xcz.borrow_history.domain.UionPK;
import com.xcz.common.BaseAction;
import com.xcz.recommendation.domain.Recommendation;
import com.xcz.recommendation.service.recommendService;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import static com.xcz.constant.MyConstant.UNHANDLE;


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

    public String add() {
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
        recommendation.setState(UNHANDLE);
        return this.getService().addrecommend(recommendation)?SUCCESS:ERROR;
    }

    public String queryByAjax(){
        HttpServletRequest rq = ServletActionContext.getRequest();
        int page = Integer.parseInt(rq.getParameter("page"));
        String type = rq.getParameter("type");
        ArrayList<Recommendation> data = service.get(page, 5, type);
        int page_cnt = service.getPageCount(5, type);
        if (data == null){
            rq.getSession().removeAttribute("recom_result");
            return ERROR;
        }
        rq.getSession().setAttribute("recom_result", data);
        JSONArray result = new JSONArray();
        JSONObject p = new JSONObject();
        p.put("page_cnt", page_cnt + "");
        result.add(p);
        for (Recommendation recom: data){
            JSONObject a = new JSONObject();
            a.put("user_id", recom.getUionPK().getUser_id());
            a.put("ISBN", recom.getUionPK().getISBN());
            a.put("book_name", recom.getBook_name());
            a.put("lang", recom.getLang());
            a.put("author", recom.getAuthor());
            a.put("press", recom.getPress());
            a.put("price", recom.getPrice().toString());
            a.put("amount", recom.getAmount().toString());
            a.put("reason", recom.getReason());
            a.put("state", recom.getState());
            result.add(a);
        }
        HttpServletResponse rp = ServletActionContext.getResponse();
        rp.setContentType("application/json;charset=UTF8");
        try {
            rp.getWriter().append(result.toJSONString());
            rp.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String updateState(){
        HttpServletRequest rq = ServletActionContext.getRequest();
        String id = rq.getParameter("user_id");
        String isbn = rq.getParameter("ISBN");
        String state = rq.getParameter("state");
        return service.handleRecom(id, isbn, state) ? SUCCESS: ERROR;
    }
}
