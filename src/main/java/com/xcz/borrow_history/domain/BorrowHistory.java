package com.xcz.borrow_history.domain;

import java.sql.Date;

/**
 * Created by yhq on 2016/10/9.
 */
public class BorrowHistory {
    private Date return_date;
    private Date actual_date;

    UionPK uionPK = new UionPK();

    public UionPK getUionPK() {
        return uionPK;
    }

    public void setUionPK(UionPK uionPK) {
        this.uionPK = uionPK;
    }

    public BorrowHistory(){}

    public BorrowHistory( Date return_date, Date actual_date) {
        this.return_date = return_date;
        this.actual_date = actual_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public Date getActual_date() {
        return actual_date;
    }

    public void setActual_date(Date actual_date) {
        this.actual_date = actual_date;
    }
}
