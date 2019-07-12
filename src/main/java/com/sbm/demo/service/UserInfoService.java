package com.sbm.demo.service;

import com.sbm.demo.bean.UserInfo;
import com.sbm.demo.mapper.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    public void insert(UserInfo t) {
        userInfoDao.insert(t);
    }

    public void update(UserInfo t) {
        userInfoDao.update(t);
    }

    public void delete(Integer id) {
        userInfoDao.delete(id);
    }

    public UserInfo selectOne(Integer id) {
        return userInfoDao.selectOne(id);
    }
}
