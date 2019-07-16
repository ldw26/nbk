package com.sbm.demo.service;

import com.sbm.demo.bean.UserInfo;
import com.sbm.demo.mapper.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    public int insert(UserInfo t) {
        return userInfoDao.insert(t);
    }

    public int  update(UserInfo t) {
        return userInfoDao.update(t);
    }

    public int delete(Integer id) {
        return userInfoDao.delete(id);
    }

    public UserInfo selectOne(Integer id) {
        return userInfoDao.selectOne(id);
    }

    public UserInfo selectByUserName(String userName){
        return userInfoDao.selectByUserName(userName);
    }

    public int deleteByUserName(String userName){
        return userInfoDao.deleteByUserName(userName);
    }

    //用户存款的修改
    public int userDepositChange(UserInfo userInfo){
        return userInfoDao.userDepositChange(userInfo);
    }
}
