package com.xcz.borrow_history.action;

import com.alibaba.fastjson.JSONObject;
import com.xcz.borrow_history.domain.BorrowHistory;
import com.xcz.borrow_history.domain.Reservation;
import com.xcz.borrow_history.domain.resultForRecord;
import com.xcz.borrow_history.domain.resultForReserve;
import com.xcz.borrow_history.service.BorrowInfoService;
import com.xcz.common.BaseAction;
import com.xcz.search.domain.Book;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhq on 2016/10/9.
 */
public class BorrowInfoAcion extends BaseAction {
    private BorrowHistory[] histories;
    private Reservation[] reservations;
    private ArrayList<Book> curBorrowBooks;
    private ArrayList<Book> borrowBooks;
    private ArrayList<Book> reserveBooks;
    private BorrowInfoService borrowInfoService;
    private ArrayList<BorrowHistory> borrowHistories;

    public BorrowInfoService getBorrowInfoService() {
        return borrowInfoService;
    }

    public void setBorrowInfoService(BorrowInfoService borrowInfoService) {
        this.borrowInfoService = borrowInfoService;
    }

    public String queryBorrow() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String user_id = (String) request.getSession().getAttribute("id");
        if (user_id == null) {
            return ERROR;
        }
        // 获取所有借阅记录
        histories = this.getBorrowInfoService().check(user_id);
        // 查询借阅
        if (histories != null) {
            // 有借阅的书未必有当前外借的书
            // curIds为当前外借的book_id
            // ids为已还的book_id
            ArrayList<String> ids = new ArrayList<String>();
            ArrayList<String> curIds = new ArrayList<String>();
            // borrowHistories为已还书记录
            borrowHistories = new ArrayList<BorrowHistory>();

            for (int i = 0; i < histories.length; i++) {
                // 如果没有记录归还日期则当前外借
                if (histories[i].getReturn_date() == null) {
                    curIds.add(histories[i].getUionPK().getBook_id());
                } else {
                    ids.add(histories[i].getUionPK().getBook_id());
                    borrowHistories.add(histories[i]);
                }
            }

            if (ids.isEmpty()) {
                request.getSession().setAttribute("borrow_count", 0);
            } else {
                // 已还的书
                borrowBooks = this.getBorrowInfoService().queryBooks(ids);
                resultForRecord[] result = new resultForRecord[borrowHistories.size()];
                for (int i = 0; i < borrowHistories.size(); i++) {
                    result[i] = new resultForRecord();
                    result[i].book_name = borrowBooks.get(i).getBook_name();
                    result[i].author = borrowBooks.get(i).getAuthor();
                    result[i].pub_year = borrowBooks.get(i).getPub_year();
                    result[i].return_date = borrowHistories.get(i).getReturn_date();
                    result[i].due_date = borrowHistories.get(i).getUionPK().getDue_date();
                }
                request.getSession().setAttribute("borrow_count", borrowHistories.size());
                request.getSession().setAttribute("borrow_books", result);
            }

            if (curIds.isEmpty()) {
                request.getSession().setAttribute("cur_borrow_count", 0);
            } else {
                curBorrowBooks = this.getBorrowInfoService().queryBooks(curIds);
                request.getSession().setAttribute("cur_borrow_count", curIds.size());
                request.getSession().setAttribute("cur_borrow_books", curBorrowBooks);
            }
        } else {
            request.getSession().setAttribute("borrow_count", 0);
            request.getSession().setAttribute("cur_borrow_count", 0);
        }

        // 查询预约
        reservations = this.getBorrowInfoService().queryReserve(user_id);
        if (reservations != null) {
            ArrayList<String> ids = new ArrayList<String>();
            for (int i = 0; i < reservations.length; i++) {
                ids.add(reservations[i].getUionPK().getBook_id());
            }
            reserveBooks = this.getBorrowInfoService().queryBooks(ids);

            resultForReserve[] result = new resultForReserve[reservations.length];
            for (int i = 0; i < reservations.length; i++) {
                result[i] = new resultForReserve();
                result[i].book_name = reserveBooks.get(i).getBook_name();
                result[i].author = reserveBooks.get(i).getAuthor();
                result[i].status = reservations[i].getState();
            }
            request.getSession().setAttribute("reserve_count", ids.size());
            request.getSession().setAttribute("reserve_books", result);
        } else {
            request.getSession().setAttribute("reserve_count", 0);
        }
        return SUCCESS;
    }

    // 借书
    public void ajaxCallBack() {
        HttpServletRequest rq = ServletActionContext.getRequest();
        String book_id = rq.getParameter("book_id");
        String user_id = rq.getParameter("user_id");
        String result_message;
        Book temp = this.getBorrowInfoService().queryBook(book_id);
        if (temp == null) {
            result_message = "ID is Wrong!";
        } else if ("Available".equals(temp.getState())) {
            if (this.getBorrowInfoService().add(user_id, book_id)) {
                result_message = "Borrow success";
            } else {
                result_message = "Borrow failed,please try later";
            }
        } else {
            result_message = "This book has been reserved";
        }
        JSONObject a = new JSONObject();
        a.put("message", result_message);
        HttpServletResponse rp = ServletActionContext.getResponse();
        rp.setContentType("text/html;charset=UTF8");
        try {
            rp.getWriter().append(a.toJSONString());
            rp.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

    public void returnBook() {
        HttpServletRequest rq = ServletActionContext.getRequest();
        String book_id = rq.getParameter("book_id");
        String result_message = this.getBorrowInfoService().returnBook(book_id);
        JSONObject a = new JSONObject();
        a.put("message", result_message);
        HttpServletResponse rp = ServletActionContext.getResponse();
        rp.setContentType("text/html;charset=UTF8");
        try {
            rp.getWriter().append(a.toJSONString());
            rp.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

}
