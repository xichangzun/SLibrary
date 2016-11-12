package com.xcz.recommendation.domain;

import java.io.Serializable;

/**
 * Created by yhq on 2016/11/12.
 */
public class RecomUionPK implements Serializable{
    private String user_id;
    private String ISBN;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean equals(Object obj){
        if (obj instanceof RecomUionPK){
            RecomUionPK t = (RecomUionPK) obj;
            if (this.user_id.equals(t.getUser_id()) && this.ISBN.equals(t.getISBN())){
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

}
