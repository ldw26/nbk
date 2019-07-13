package com.sbm.demo.mapper;

import com.sbm.demo.bean.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoDao {

    //TODO 增
    public int insert(UserInfo userInfo);

    //TODO 改
    public int update(UserInfo userInfo);

    //TODO 删
    public int delete(Integer id);

    //TODO 根据ID查找
    public UserInfo selectOne(Integer id);
}
