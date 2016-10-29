package com.xcz.borrow_history.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by yhq on 2016/10/9.
 */
public class BorrowUionPK implements Serializable{
    private String user_id;
    private String ISBN;
    private Timestamp return_date;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getISBN() {
        return ISBN;
    }

    public Timestamp getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Timestamp return_date) {
        this.return_date = return_date;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean equals(Object obj){
        if (obj instanceof BorrowUionPK){
            BorrowUionPK t = (BorrowUionPK) obj;
            if (this.user_id.equals(t.getUser_id()) && this.ISBN.equals(t.getISBN()) && this.return_date.equals(t.getReturn_date())){
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
