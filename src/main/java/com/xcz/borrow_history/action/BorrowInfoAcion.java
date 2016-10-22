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

    public BorrowInfoService getBorrowInfoService(){
        return borrowInfoService;
    }

    public void setBorrowInfoService(BorrowInfoService borrowInfoService){
        this.borrowInfoService = borrowInfoService;
    }

    public String queryBorrow(){
        HttpServletRequest request = ServletActionContext.getRequest();
        String user_id = (String) request.getSession().getAttribute("id");
        if(user_id == null){
            System.out.println(ERROR);
            return ERROR;
        }

        histories = this.getBorrowInfoService().check(user_id);
        // 查询借阅
        if (histories != null){
            // 有借阅的书未必有当前外借的书
            ArrayList<String> ISBNs = new ArrayList<String>();
            ArrayList<String> curISBNs = new ArrayList<String>();
            borrowHistories = new ArrayList<BorrowHistory>();

            for (int i=0; i<histories.length; i++){

                // 如果没有记录实际归还日期则当前外借
                if (histories[i].getActual_date() == null){
                    curISBNs.add(histories[i].getUionPK().getISBN());
                }
                else //已经归还
                {
                    ISBNs.add(histories[i].getUionPK().getISBN());
                    borrowHistories.add(histories[i]);
                }
            }
            //System.out.println(borrowHistories.size());
            if(ISBNs.isEmpty())
            {
                request.getSession().setAttribute("borrow_count",0);
            }
            else
            {
                borrowBooks = this.getBorrowInfoService().queryBooks(ISBNs);
                /*System.out.println(borrowBooks.size());
                System.out.println(borrowHistories.size());*/
                resultForRecord[] result = new resultForRecord[borrowHistories.size()];
                for(int i = 0;i<borrowHistories.size();i++)
                {
                    result[i] = new resultForRecord();
                    result[i].book_name = borrowBooks.get(i).getBook_name();
                    result[i].author = borrowBooks.get(i).getAuthor();
                    result[i].pub_year = borrowBooks.get(i).getPub_year();
                    result[i].return_date = borrowHistories.get(i).getReturn_date();
                    result[i].actual_date = borrowHistories.get(i).getActual_date();
                }

                request.getSession().setAttribute("borrow_count",borrowHistories.size());
                request.getSession().setAttribute("borrow_books",result);
            }

            if (curISBNs.isEmpty()){
                request.getSession().setAttribute("cur_borrow_count", 0);
            } else {
                curBorrowBooks = this.getBorrowInfoService().queryBooks(curISBNs);
                request.getSession().setAttribute("cur_borrow_count", curISBNs.size());
                request.getSession().setAttribute("cur_borrow_books", curBorrowBooks);
            }
        } else {
            request.getSession().setAttribute("borrow_count", 0);
            request.getSession().setAttribute("cur_borrow_count", 0);
        }

        // 查询预约
        reservations = this.getBorrowInfoService().queryReserve(user_id);
        if (reservations != null){
            ArrayList<String> ISBNs = new ArrayList<String>();
            for (int i=0; i<reservations.length; i++){
                ISBNs.add(reservations[i].getUionPK().getISBN());
            }
            reserveBooks = this.getBorrowInfoService().queryBooks(ISBNs);

            resultForReserve[] result = new resultForReserve[reservations.length];
            for (int i=0;i<reservations.length;i++){
                result[i] = new resultForReserve();
                result[i].book_name = reserveBooks.get(i).getBook_name();
                result[i].author = reserveBooks.get(i).getAuthor();
                if(reservations[i].getStatus())
                {
                    result[i].status = "OK";
                }
                else
                {
                    result[i].status = "Waiting";
                }
            }
            request.getSession().setAttribute("reserve_count", ISBNs.size());
            request.getSession().setAttribute("reserve_books", result);
        } else {
            request.getSession().setAttribute("reserve_count", 0);
        }
        return SUCCESS;
    }

    public void ajaxCallBack(){
        HttpServletRequest rq = ServletActionContext.getRequest();
        String ISBN = rq.getParameter("ISBN");
        String user_id = rq.getParameter("User_id");
        String result_message;
        Book temp = this.getBorrowInfoService().queryBook(ISBN);
        if(temp == null)
        {
            result_message = "ISBN错误，没有该书";
        }
        else if(temp.getAmount()>temp.getRes_amount())
        {
            if(this.getBorrowInfoService().add(user_id,ISBN))
            {

                result_message = "borrow success";
            }
            else
            {
                result_message = "borrow failed,try later";
            }
        }
        else
        {
            result_message = "this book has been reserved";
        }
        JSONObject a = new JSONObject();
        a.put("message",result_message);
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

    public void returnBook()
    {

    }

}
