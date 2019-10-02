package com.cskaoyan.mall.vo.voSJB;

import com.cskaoyan.mall.bean.Collect;

import java.util.List;

public class DataForCollectListVo {
    private int total;//total代表收藏总数
    private List<Collect> items;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Collect> getItems() {
        return items;
    }

    public void setItems(List<Collect> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "DataForCollectListVo{" +
                "total=" + total +
                ", items=" + items +
                '}';
    }

    public DataForCollectListVo(int total, List<Collect> items) {
        this.total = total;
        this.items = items;
    }

    public DataForCollectListVo() {
    }
}
