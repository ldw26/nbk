package com.sbm.demo.bean;

import java.io.Serializable;

/**
 * 订单项
 */
public class Item implements Serializable {

    private static final long serialVersionUID =0001L;
    private Integer id;
    private String itemName;
    private Order order;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", order=" + order +
                '}';
    }
}
