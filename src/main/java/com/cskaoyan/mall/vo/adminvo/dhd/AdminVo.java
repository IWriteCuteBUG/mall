package com.cskaoyan.mall.vo.adminvo.dhd;

import com.cskaoyan.mall.bean.Admin;

import java.util.List;

public class AdminVo {
   public  List<Admin> items;
   public   int  total;

    public List<Admin> getItems() {
        return items;
    }

    public void setItems(List<Admin> items) {
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
        return "AdminVo{" +
                "items=" + items +
                ", total=" + total +
                '}';
    }
}
