package com.cskaoyan.mall.vo.adminvo.voLJW;

import com.cskaoyan.mall.bean.Order;

import java.util.List;

public class ReturnOrders {
    private  int total;
    private List<Order> items;

    public ReturnOrders(int total, List<Order> items) {
        this.total = total;
        this.items = items;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Order> getItems() {
        return items;
    }

    public void setItems(List<Order> items) {
        this.items = items;
    }
}
