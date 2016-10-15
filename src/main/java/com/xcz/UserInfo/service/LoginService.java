package com.xcz.UserInfo.service;

import com.xcz.UserInfo.domain.UserInfo;

/**
 * Created by root on 16-10-8.
 */
public interface LoginService {
    UserInfo check(String user_name,String pwd);
    Boolean changePassWord(String user_name,String new_pwd);
}
