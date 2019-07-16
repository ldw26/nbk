package com.sbm.demo.mapper;

import com.sbm.demo.bean.FundInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FundInfoDao {


    //TODO 改
    public void update(FundInfo fundInfo);

    //TODO 删
    public void delete(@Param("fundId") Integer fundId);

    //TODO 根据ID查找
    public FundInfo selectOne(@Param("fundId")Integer fundId);

    //TODO 查询所有的基金信息
    public List<FundInfo> selectAll();
}
