package com.sbm.demo.mapper;


import com.sbm.demo.bean.Login;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {

    //TODO 增
    public void insert(Login login);

    //TODO 改
    public void update(Login login);

    //TODO 删
    public void delete(Integer id);

    //TODO 根据ID查找
    public Login selectOne(Integer id);
}
