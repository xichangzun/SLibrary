package com.xcz.borrow_history.domain;

import java.io.Serializable;

/**
 * Created by yhq on 2016/11/12.
 */
public class ResUionPK implements Serializable{
    private String user_id;
    private String book_id;

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

    public boolean equals(Object obj){
        if (obj instanceof ResUionPK){
            ResUionPK t = (ResUionPK) obj;
            if (this.user_id.equals(t.getUser_id()) && this.book_id.equals(t.getBook_id())){
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
