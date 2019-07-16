package com.sbm.demo.service;

import com.sbm.demo.bean.Login;
import com.sbm.demo.mapper.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class LoginService {


    @Autowired
    private LoginDao loginDao;

    public int insert(Login t) {
        return loginDao.insert(t);
    }

    public int update(Login t) {
        return loginDao.update(t);
    }

    public int delete(Integer id) {
        return  loginDao.delete(id);
    }

    public Login selectOne(Integer id) {
        return loginDao.selectOne(id);
    }

    public Login selectOneByUserNameAndPassword(String userName,String password){
        return loginDao.selectOneByUserNameAndPassword(userName,password);
    }

    public int deleteByUserName(String userName){
        return loginDao.deleteByUserName(userName);
    }
}
