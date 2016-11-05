package com.xcz.News.domain;

import com.xcz.common.BaseBean;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by root on 16-11-4.
 */
public class News extends BaseBean implements Serializable {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    private Integer id;
    private String title;
    private String summary;
    private String content;
    private String add_time;

    public News() {
    }

    public News(Integer id, String title, String summary, String content, String add_time) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.add_time = add_time;
    }
}
