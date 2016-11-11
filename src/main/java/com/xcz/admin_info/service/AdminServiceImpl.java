package com.xcz.admin_info.service;

import com.xcz.admin_info.domain.Admin;
import com.xcz.common.BaseService;

import java.util.List;

/**
 * Created by yhq on 2016/10/23.
 */
public class AdminServiceImpl extends BaseService implements AdminService {

    public Admin login(String id, String pwd) {
        String sql = "SELECT * FROM ADMIN WHERE id = '" + id + "' AND pwd = '" + pwd + "'";
        List result = this.getHibernateDAO().findBySql(sql);
        if (result == null || result.isEmpty()) {
            return null;
        } else {
            Object[] o = (Object[]) result.get(0);
            Admin data = new Admin();
            data.setId((String) o[0]);
            data.setUser_name((String) o[1]);
            data.setPwd((String) o[2]);
            data.setUnit((String) o[3]);
            return data;
        }
    }
}
