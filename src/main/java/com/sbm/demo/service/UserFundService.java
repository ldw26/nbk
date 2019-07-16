package com.sbm.demo.service;

import com.sbm.demo.bean.UserFund;
import com.sbm.demo.bean.UserFundList;
import com.sbm.demo.mapper.UserFundDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserFundService {

    @Autowired
    private UserFundDao userFundDao;

    public int insert(UserFund t) {
        return userFundDao.insert(t);
    }

    public void delete(Integer id) {
        userFundDao.delete(id);
    }

    public UserFund selectOne(int userId,int fundId) {

        return userFundDao.selectOneByUserIdAndFundId(userId,fundId);
    }

    public List<UserFundList> selectFundMoneyAndName(Integer userId){
        return userFundDao.selectFundMoneyAndName(userId);
    }

    public int updateFundMoney(UserFund userFund){
        return userFundDao.updateFundMoney(userFund);
    }
}
