package com.xcz.admin_info.domain;

/**
 * Created by yhq on 2016/10/23.
 */
public class Admin {
    private String id;
    private String user_name;
    private String pwd;
    private String unit;

    public Admin(){}

    public Admin(String id, String user_name, String pwd, String unit) {
        this.id = id;
        this.user_name = user_name;
        this.pwd = pwd;
        this.unit = unit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
