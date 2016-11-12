package com.xcz.search.domain;

import java.sql.Date;

/**
 * Created by root on 16-10-9.
 */
public class Book {
    private String id;
    private String ISBN;
    private String book_name;
    private String lang;
    private String author;
    private String press;
    private String pub_year;
    private String call_no;
    private String state;
    private Integer pages;
    private Integer size;
    private String cover;

    public Book() {}

    public Book(String id, String ISBN, String book_name, String lang, String author, String press, String pub_year, String call_no, String state, Integer pages, Integer size, String cover) {
        this.id = id;
        this.ISBN = ISBN;
        this.book_name = book_name;
        this.lang = lang;
        this.author = author;
        this.press = press;
        this.pub_year = pub_year;
        this.call_no = call_no;
        this.state = state;
        this.pages = pages;
        this.size = size;
        this.cover = cover;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

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

    public String getPub_year() {
        return pub_year;
    }

    public void setPub_year(String pub_year) {
        this.pub_year = pub_year;
    }

    public String getCall_no() {
        return call_no;
    }

    public void setCall_no(String call_no) {
        this.call_no = call_no;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
}
