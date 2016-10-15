package com.xcz.borrow_history.domain;

/**
 * Created by yhq on 2016/10/9.
 */
public class Reservation {
    private Boolean status;

    UionPK uionPK = new UionPK();

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public UionPK getUionPK() {
        return uionPK;
    }

    public void setUionPK(UionPK uionPK) {
        this.uionPK = uionPK;
    }

    public Reservation(){}

    public Reservation(Boolean status, UionPK uionPK) {
        this.status = status;
        this.uionPK = uionPK;
    }
}
