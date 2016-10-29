package com.xcz.borrow_history.domain;

/**
 * Created by yhq on 2016/10/9.
 */
public class Reservation {
    private String state;

    UionPK uionPK = new UionPK();

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public UionPK getUionPK() {
        return uionPK;
    }

    public void setUionPK(UionPK uionPK) {
        this.uionPK = uionPK;
    }

    public Reservation(){}

    public Reservation(String state, UionPK uionPK) {
        this.state = state;
        this.uionPK = uionPK;
    }
}
