package com.sbm.demo.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 订单类
 */
public class Order implements Serializable {

    private static final long serialVersionUID =0002L;
    private Integer id ;
    private String orderNo ;
    private User user ;
    private List<Item> items ;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", user=" + user +
                ", items=" + items +
                '}';
    }
}
