package com.sbm.demo.mapper;

import com.sbm.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserDao {

    //TODO 增
    public void insert(User user);

    //TODO 改
    public void update(User user);

    //TODO 删
    public void delete(Integer id);

    //TODO 根据ID查找
    public User selectOne(Integer id);

    //TODO 查找全部
    public List<User> selectAll();

    /**
     * TODO 分页查询
     *
     * @param offset 偏移量
     * @param len    长度
     * @return List<User>
     */
    public List<User> selectPage(int offset, int len) ;

    //TODO 查用户的总共数量
    public int selectCount();
}
