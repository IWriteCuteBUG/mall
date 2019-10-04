package com.cskaoyan.mall.vo.voLJW;

import java.io.Serializable;
import java.util.List;
//@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class ReturnData <T> implements Serializable {
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    private  int total;
    private List<T> items;

    public ReturnData(int total, List<T> items) {
        this.total = total;
        this.items = items;
    }
}
