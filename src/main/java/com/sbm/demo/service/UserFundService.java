package com.sbm.demo.service;

import com.sbm.demo.bean.UserFund;
import com.sbm.demo.mapper.UserFundDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFundService {

    @Autowired
    private UserFundDao userFundDao;

    public int insert(UserFund t) {
        return userFundDao.insert(t);
    }

    public void update(UserFund t) {
        userFundDao.update(t);
    }

    public void delete(Integer id) {
        userFundDao.delete(id);
    }

    public List<UserFund> selectOne(Integer id) {
        return userFundDao.selectOne(id);
    }
}
