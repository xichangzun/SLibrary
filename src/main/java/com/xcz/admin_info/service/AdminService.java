package com.xcz.admin_info.service;

import com.xcz.admin_info.domain.Admin;

/**
 * Created by yhq on 2016/10/23.
 */
public interface AdminService {
    Admin check(String id, String pwd);
}
