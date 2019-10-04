package com.cskaoyan.mall.vo.extensionvo;

import com.cskaoyan.mall.bean.Ad;

import java.util.List;
import java.util.Objects;

public class AdvertList<T> {
   private long total;
   private List<T> items;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
