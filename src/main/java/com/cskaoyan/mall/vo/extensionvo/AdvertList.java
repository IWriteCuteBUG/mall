package com.cskaoyan.mall.vo.extensionvo;

import com.cskaoyan.mall.bean.Ad;

import java.util.List;

public class AdvertList {
   private long total;
   private List<Ad> items;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<Ad> getItems() {
        return items;
    }

    public void setItems(List<Ad> items) {
        this.items = items;
    }
}
