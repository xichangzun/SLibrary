package com.xcz.search.domain;

import java.sql.Date;

/**
 * Created by root on 16-10-9.
 */
public class Book {
    private String book_name;

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
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

    public String getPub_year() {
        return pub_year;
    }

    public void setPub_year(String pub_year) {
        this.pub_year = pub_year;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getRes_amount() {
        return res_amount;
    }

    public void setRes_amount(Integer res_amount) {
        this.res_amount = res_amount;
    }

    public Integer getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Integer total_amount) {
        this.total_amount = total_amount;
    }

    public String getCall_no() {
        return call_no;
    }

    public void setCall_no(String call_no) {
        this.call_no = call_no;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    private String ISBN;
    private String lang;
    private String author;
    private String press;
    private String pub_year;
    private Integer amount;
    private Integer res_amount;
    private Integer total_amount;
    private String call_no;
    private Integer pages;
    private Integer size;
    private String cover;

    public Book(String book_name, String ISBN, String lang, String author, String press, String pub_year, Integer amount, Integer res_amount, Integer total_amount, String call_no, Integer pages, Integer size, String cover) {
        this.book_name = book_name;
        this.ISBN = ISBN;
        this.lang = lang;
        this.author = author;
        this.press = press;
        this.pub_year = pub_year;
        this.amount = amount;
        this.res_amount = res_amount;
        this.total_amount = total_amount;
        this.call_no = call_no;
        this.pages = pages;
        this.size = size;
        this.cover = cover;
    }

    public Book() {
    }
}
