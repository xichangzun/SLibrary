package com.xcz.borrow_history.domain;

import java.sql.Date;

/**
 * Created by root on 16-10-10.
 */
public class resultForRecord {
    public String book_name;
    public String author;
    public String pub_year;
    public Date return_date;
    public Date actual_date;

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPub_year() {
        return pub_year;
    }

    public void setPub_year(String pub_year) {
        this.pub_year = pub_year;
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
