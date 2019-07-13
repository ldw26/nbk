package com.sbm.demo.mapper;


import com.sbm.demo.bean.Login;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {

    //TODO 增
    public int insert(Login login);

    //TODO 改
    public int update(Login login);

    //TODO 删
    public int delete(Integer id);

    //TODO 根据ID查找
    public Login selectOne(Integer id);

    //TODO 根据用户名和密码查找 (登陆)
    public Login selectOneByUserNameAndPassword(String userName,String password);
}
