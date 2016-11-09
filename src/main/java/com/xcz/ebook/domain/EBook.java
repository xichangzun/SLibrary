package com.xcz.ebook.domain;

/**
 * Created by yhq on 2016/11/6.
 */
public class EBook {
    private String ebook_name;
    private String author;
    private String lang;
    private String press;
    private String cover;
    private String ISBN;
    private String pub_year;
    private Integer pages;
    private String pdf;

    public EBook(){}

    public EBook(String ebook_name, String author, String lang, String press, String cover, String ISBN, String pub_year, Integer pages, String pdf) {
        this.ebook_name = ebook_name;
        this.author = author;
        this.lang = lang;
        this.press = press;
        this.cover = cover;
        this.ISBN = ISBN;
        this.pub_year = pub_year;
        this.pages = pages;
        this.pdf = pdf;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public String getEbook_name() {

        return ebook_name;
    }

    public void setEbook_name(String ebook_name) {
        this.ebook_name = ebook_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPub_year() {
        return pub_year;
    }

    public void setPub_year(String pub_year) {
        this.pub_year = pub_year;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}
