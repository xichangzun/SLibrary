package com.xcz.borrow_history.domain;

import java.sql.Date;

/**
 * Created by yhq on 2016/10/9.
 */
public class BorrowHistory {

    private Date return_date;
    HistoryUionPK uionPK = new HistoryUionPK();

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public HistoryUionPK getUionPK() {
        return uionPK;
    }

    public void setUionPK(HistoryUionPK uionPK) {
        this.uionPK = uionPK;
    }

    public BorrowHistory(){}

    public BorrowHistory(Date return_date, HistoryUionPK uionPK) {
        this.return_date = return_date;
        this.uionPK = uionPK;
    }
}
