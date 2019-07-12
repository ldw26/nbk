package com.sbm.demo.service;


import com.sbm.demo.bean.Item;
import com.sbm.demo.bean.Order;
import com.sbm.demo.bean.User;
import com.sbm.demo.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service("userService")
public class UserService {

    @Autowired
    private UserDao dao;


    public void insert(User t) {
        dao.insert(t);
    }

    public void update(User t) {
        dao.update(t);
    }

    public void delete(Integer id) {
        dao.delete(id);
    }

    public User selectOne(Integer id) {
        return dao.selectOne(id);
    }

    public List<User> selectAll() {
        return dao.selectAll();
    }


    /**
     * 长事务测试
     */
    public void longTx() {
        //插入item
        Item i = new Item();
        i.setItemName("ttt");

        Order o = new Order();
        o.setId(2);
        //
        //itemDao.insert(i);

        this.delete(1);
    }

    //TODO 保存某一个用户的时候分成两种情况
    public void save(User u) {
        if (u.getId() != null) {
            this.update(u);
        } else {
            this.insert(u);
        }
    }
}