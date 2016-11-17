package com.xcz.borrow_history.action;

import com.alibaba.fastjson.JSONObject;
import com.xcz.UserInfo.domain.UserInfo;
import com.xcz.borrow_history.domain.BorrowHistory;
import com.xcz.borrow_history.domain.Reservation;
import com.xcz.borrow_history.domain.resultForRecord;
import com.xcz.borrow_history.domain.resultForReserve;
import com.xcz.borrow_history.service.BorrowInfoService;
import com.xcz.common.BaseAction;
import com.xcz.constant.MyConstant;
import com.xcz.recommendation.domain.RecomUionPK;
import com.xcz.recommendation.domain.Recommendation;
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
    private ArrayList<Recommendation> recs;
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

        // 查询推荐
        recs = borrowInfoService.getRecByUser(user_id);
        int rec_cnt = recs.size();
        request.getSession().setAttribute("rec_count", rec_cnt);
        request.getSession().setAttribute("recommend", recs);
        return SUCCESS;
    }

    public boolean queryUser(String id){
        return borrowInfoService.checkUser(id);
    }

    // 借书
    public void ajaxCallBack() {
        HttpServletRequest rq = ServletActionContext.getRequest();
        String book_id = rq.getParameter("book_id");
        String user_id = rq.getParameter("user_id");
        String result_message;
        // 检测书籍
        Book book = borrowInfoService.queryBook(book_id);
        // 检测用户
        Boolean isUserExist = borrowInfoService.checkUser(user_id);
        if (book == null) {
            result_message = "This book is not exit!";
        } else if(!isUserExist) {
            result_message = "This user ID is not registered!";
        } else if(borrowInfoService.getFine(user_id) > 3.0) {
            result_message = "Fine of this reader is more than $3.0!\nThe fine must be paid first!";
        }
        else if (MyConstant.AVAILABLE.equals(book.getState())) {
            result_message = borrowInfoService.add(user_id, book_id);
        } else if (MyConstant.BORROWED.equals(book.getState())){
            result_message = "This book is borrowed!";
        } else if (MyConstant.RESERVED.equals(book.getState())) {
            if(borrowInfoService.getRes(book_id).equals(user_id)){
                if(borrowInfoService.deleteRes(user_id,book_id) != 1){
                    result_message = "Borrow failed,can't delete the reservation";
                }
                else {
                    result_message = borrowInfoService.add(user_id,book_id);
                }
            }else {
                result_message = "This book is reserved!";
            }
        } else {
            result_message = "Book status is unknown!";
        }
        JSONObject a = new JSONObject();
        a.put("message", result_message);
        setAjaxResponse("text/html;charset=UTF8", a.toJSONString());
        return;
    }

    public void returnBook() {
        HttpServletRequest rq = ServletActionContext.getRequest();
        String book_id = rq.getParameter("book_id");
        Book book = borrowInfoService.queryBook(book_id);
        String msg;
        JSONObject json = new JSONObject();
        // 检测书本是否存在
        if (book != null) {
            String result_message = this.getBorrowInfoService().returnBook(book_id);
            json.put("message", result_message);
        } else {
            json.put("message", "This book is not exist!");
        }
        msg = json.toJSONString();
        setAjaxResponse("text/html;charset=UTF8", msg);
        return;
    }

}
