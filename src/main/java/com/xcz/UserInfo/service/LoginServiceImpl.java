package com.xcz.UserInfo.service;

import com.xcz.UserInfo.domain.UserInfo;
import com.xcz.common.BaseService;

import java.util.List;

/**
 * Created by root on 16-10-8.
 */
public class LoginServiceImpl extends BaseService implements LoginService {

    public UserInfo check(String id, String pwd) {
        String sql = "select * from USER where id = '" + id + "' AND pwd = '" + pwd + "'";
        List result = this.getHibernateDAO().findBySql(sql);
        if (result == null || result.isEmpty()) {
            return null;
        } else {
            Object[] temp = (Object[]) result.get(0);
            UserInfo data = new UserInfo();
            data.setId((String) temp[0]);
            data.setUser_name((String) temp[1]);
            data.setPwd((String) temp[2]);
            if (temp.length >= 4) data.setUnit((String) temp[3]);
            if (temp.length >= 5) data.setEmail((String) temp[4]);
            if (temp.length >= 6) data.setTel((String) temp[5]);
            return data;
        }
    }

    public Boolean changePassWord(String user_name, String new_password) {
        String sql = "update USER  set pwd = '" + new_password + "' where id = '" + user_name + "'";
        return this.getHibernateDAO().executeBySql(sql);
    }

    public Boolean register(UserInfo userInfo) {
        String sql = "SELECT * from USER WHERE id = '"+ userInfo.getId() +"'";
        List result = this.getHibernateDAO().findBySql(sql);
        if (result.size() == 0){
            sql = "INSERT INTO USER VALUES ('"+userInfo.getId()+"', '"+ userInfo.getUser_name()+"', '"+userInfo.getPwd()+"'" +
                    "'"+userInfo.getUnit()+"', '"+userInfo.getEmail()+"', '"+userInfo.getTel()+"'";
            this.getHibernateDAO().findBySql(sql);
            return true;
        } else {
            return false;
        }
    }
}
