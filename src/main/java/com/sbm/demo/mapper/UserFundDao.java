package com.sbm.demo.mapper;

import com.sbm.demo.bean.UserFund;
import com.sbm.demo.bean.UserFundList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserFundDao {
    //TODO 增
    public int insert(UserFund userFund);

    //TODO 删
    public void delete(@Param("userId")Integer id);

    //TODO 根据用户ID和基金ID查找特定的基金
    public UserFund selectOneByUserIdAndFundId(@Param("userId")Integer userId,@Param("fundId")Integer fundId);

    //TODO 根据ID查询基金Id、基金名称及其购买金钱数
    public List<UserFundList> selectFundMoneyAndName(@Param("userId") Integer userId);

    //TODO 只更新基金数（含有数据：userId、fundId、fundMoney）
    public int updateFundMoney(UserFund userFund);
}
