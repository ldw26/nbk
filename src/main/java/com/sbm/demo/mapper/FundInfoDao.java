package com.sbm.demo.mapper;

import com.sbm.demo.bean.FundInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FundInfoDao {

    //TODO 增
    public void insert(FundInfo fundInfo);

    //TODO 改
    public void update(FundInfo fundInfo);

    //TODO 删
    public void delete(Integer id);

    //TODO 根据ID查找
    public FundInfo selectOne(Integer id);
}
