package com.xcz.borrow_history.domain;

import java.sql.Date;

/**
 * Created by yhq on 2016/10/9.
 */
public class Reservation {
    private String state;
    private Date res_date;
    ResUionPK uionPK = new ResUionPK();

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getRes_date() {
        return res_date;
    }

    public void setRes_date(Date res_date) {
        this.res_date = res_date;
    }

    public ResUionPK getUionPK() {
        return uionPK;
    }

    public void setUionPK(ResUionPK uionPK) {
        this.uionPK = uionPK;
    }

    public Reservation(){}

    public Reservation(String state, Date res_date, ResUionPK uionPK) {
        this.state = state;
        this.res_date = res_date;
        this.uionPK = uionPK;
    }
}
