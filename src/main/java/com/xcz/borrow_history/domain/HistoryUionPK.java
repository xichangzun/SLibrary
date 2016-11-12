package com.xcz.borrow_history.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by yhq on 2016/11/12.
 */
public class HistoryUionPK implements Serializable{
    private String user_id;
    private String book_id;
    private Date due_date;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public boolean equals(Object obj){
        if (obj instanceof HistoryUionPK){
            HistoryUionPK t = (HistoryUionPK) obj;
            if (this.user_id.equals(t.getUser_id()) && this.book_id.equals(t.getBook_id()) && this.due_date.equals(t.getDue_date())){
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
