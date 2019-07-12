package com.sbm.demo.service;

import com.sbm.demo.bean.UserFund;
import com.sbm.demo.mapper.UserFundDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFundService {

    @Autowired
    private UserFundDao userFundDao;

    public void insert(UserFund t) {
        userFundDao.insert(t);
    }

    public void update(UserFund t) {
        userFundDao.update(t);
    }

    public void delete(Integer id) {
        userFundDao.delete(id);
    }

    public UserFund selectOne(Integer id) {
        return userFundDao.selectOne(id);
    }
}
