package com.sbm.demo.service;

import com.sbm.demo.bean.FundView;
import com.sbm.demo.mapper.FundViewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class FundViewService {
    @Autowired
    private FundViewDao fundViewDao;

    //查看实时基金池的状态 ---》包含基金名称，基金购买人数，基金购买总量
    public List<FundView> selectAll(){
        return fundViewDao.selectAll();
    }

}
