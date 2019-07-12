package com.sbm.demo.mapper;

import com.sbm.demo.bean.UserFund;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserFundDao {
    //TODO 增
    public void insert(UserFund userFund);

    //TODO 改
    public void update(UserFund userFund);

    //TODO 删
    public void delete(Integer id);

    //TODO 根据ID查找
    public UserFund selectOne(Integer id);
}
