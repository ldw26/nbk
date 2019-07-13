package com.sbm.demo.service;

import com.sbm.demo.bean.FundInfo;
import com.sbm.demo.mapper.FundInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FundInfoService {

    @Autowired
    private FundInfoDao fundInfoDao;

    public void insert(FundInfo t) {
        fundInfoDao.insert(t);
    }

    public void update(FundInfo t) {
        fundInfoDao.update(t);
    }

    public void delete(Integer id) {
        fundInfoDao.delete(id);
    }

    public FundInfo selectOne(Integer id) {
        return fundInfoDao.selectOne(id);
    }

    public List<FundInfo> selectAll(){
        return fundInfoDao.selectAll();
    }
}
