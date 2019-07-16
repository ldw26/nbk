package com.sbm.demo.mapper;

import com.sbm.demo.bean.FundView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FundViewDao {

    //查看实时基金池的状态 ---》包含基金名称，基金购买人数，基金购买总量
    public List<FundView> selectAll();
}
