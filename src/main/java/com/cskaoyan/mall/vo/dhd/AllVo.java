package com.cskaoyan.mall.vo.dhd;

import com.cskaoyan.mall.bean.Log;

import java.util.List;

public class AllVo<T> {
    private List<T> items;
    private int total;


    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "AllVo{" +
                "items=" + items +
                ", total=" + total +
                '}';
    }
}
