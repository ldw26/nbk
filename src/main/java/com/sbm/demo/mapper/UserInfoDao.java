package com.sbm.demo.mapper;

import com.sbm.demo.bean.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserInfoDao {

    //TODO 增
    public int insert(UserInfo userInfo);

    //TODO 改
    public int update(UserInfo userInfo);

    //TODO 删
    public int delete(@Param("userId")Integer userId);

    //TODO 根据ID查找（也就是查询当前用户的存款等一些信息）
    public UserInfo selectOne(@Param("userId") Integer userId);

    //TODO 根据用户名进行查询
    public UserInfo selectByUserName(@Param("userName") String userName);

    //TODO 根据用户名删除
    public int deleteByUserName(@Param("userName")String userName);

    //TODO 用户存款的修改
    public int userDepositChange(UserInfo userInfo);

}
