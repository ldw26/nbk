package com.sbm.demo.utils;


import com.sbm.demo.bean.Login;

public class StringECC {
    //TODO 对登陆时传入用户名和密码的校验
    public static Boolean userNameAndPasswordECC(Login login){
        if (login.getLogName()!=null && login.getPassword()!=null){
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }

    }
}
