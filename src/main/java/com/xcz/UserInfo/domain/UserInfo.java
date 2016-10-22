package com.xcz.UserInfo.domain;

/**
 * Created by root on 16-10-7.
 */
public class UserInfo {
    String id;
    String user_name;
    String pwd;
    String unit;
    String email;
    String tel;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public UserInfo(){}

    public UserInfo(String id,String user_name,String pwd,String unit){
        this.id = id;
        this.user_name = user_name;
        this.pwd = pwd;
        this.unit = unit;
    }

    public UserInfo(String id,String user_name,String pwd,String unit,String email,String tel){
        this.id = id;
        this.user_name = user_name;
        this.pwd = pwd;
        this.unit = unit;
        this.email = email;
        this.tel = tel;
    }
}
