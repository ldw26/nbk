package com.sbm.demo.service;

import com.sbm.demo.bean.Login;
import com.sbm.demo.mapper.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {


    @Autowired
    private LoginDao loginDao;

    public void insert(Login t) {
        loginDao.insert(t);
    }

    public void update(Login t) {
        loginDao.update(t);
    }

    public void delete(Integer id) {
        loginDao.delete(id);
    }

    public Login selectOne(Integer id) {
        return loginDao.selectOne(id);
    }
}
