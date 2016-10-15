package com.xcz.recommendation.domain;

import com.xcz.borrow_history.domain.UionPK;
import com.xcz.common.BaseBean;

import java.io.Serializable;

/**
 * Created by root on 16-10-15.
 */
public class Recommendation extends BaseBean implements Serializable {
    UionPK uionPK = new UionPK();
    private String book_name;
    private String lang;
    private String author;
    private String press;
    private Float price;
    private Integer amount;
    private String reason;
    private Boolean status;


    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Recommendation() {}

    public Recommendation(UionPK uionPK, String book_name, String lang, String author, String press, Float price, Integer amount, String reason, Boolean status) {
        this.uionPK = uionPK;
        this.book_name = book_name;
        this.lang = lang;
        this.author = author;
        this.press = press;
        this.price = price;
        this.amount = amount;
        this.reason = reason;
        this.status = status;
    }
}
