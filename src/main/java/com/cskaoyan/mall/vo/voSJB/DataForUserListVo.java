package com.cskaoyan.mall.vo.voSJB;

import com.cskaoyan.mall.bean.User;

import java.util.List;

public class DataForUserListVo {
    private int total;//total代表用户总数
    private List<User> items;

    public DataForUserListVo(int total, List<User> items) {
        this.total = total;
        this.items = items;
    }

    public DataForUserListVo() {
    }

    @Override
    public String toString() {
        return "DataForUserListVo{" +
                "total=" + total +
                ", items=" + items +
                '}';
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<User> getItems() {
        return items;
    }

    public void setItems(List<User> items) {
        this.items = items;
    }
}
