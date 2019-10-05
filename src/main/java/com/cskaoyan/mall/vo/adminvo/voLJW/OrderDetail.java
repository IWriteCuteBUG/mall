package com.cskaoyan.mall.vo.adminvo.voLJW;


import com.cskaoyan.mall.bean.Order;
import com.cskaoyan.mall.bean.OrderGoods;
import com.cskaoyan.mall.bean.User;

import java.util.List;

public class OrderDetail {
    private List<OrderGoods> orderGoods;
    private User user;
    private  Order order;

    public OrderDetail(List<OrderGoods> orderGoods, User user, Order order) {
        this.orderGoods = orderGoods;
        this.user = user;
        this.order = order;
    }

    public List<OrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<OrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
