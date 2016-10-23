package com.xcz.admin_info.service;

import com.xcz.admin_info.domain.Admin;
import com.xcz.common.BaseService;

import java.util.List;

/**
 * Created by yhq on 2016/10/23.
 */
public class AdminServiceImpl extends BaseService implements AdminService {

    public Admin check(String id, String pwd) {
        String sql = "SELECT * FROM ADMIN where id = '" + id + "' AND pwd = '" + pwd + "'";
        List result = this.getHibernateDAO().findBySql(sql);
        if (result == null || result.isEmpty()) {
            return null;
        } else {
            Object[] temp = (Object[]) result.get(0);
            Admin data = new Admin();
            data.setId((String) temp[0]);
            data.setUser_name((String) temp[1]);
            data.setPwd((String) temp[2]);
            if (temp.length >= 4) data.setUnit((String) temp[3]);
            return data;
        }
    }
}
