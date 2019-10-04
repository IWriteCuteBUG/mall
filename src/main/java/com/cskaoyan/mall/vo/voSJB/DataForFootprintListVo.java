package com.cskaoyan.mall.vo.voSJB;

import com.cskaoyan.mall.bean.Footprint;


import java.util.List;

public class DataForFootprintListVo {
    private int total;//total代表足迹总数
    private List<Footprint> items;

    @Override
    public String toString() {
        return "DataForFootprintListVo{" +
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

    public List<Footprint> getItems() {
        return items;
    }

    public void setItems(List<Footprint> items) {
        this.items = items;
    }

    public DataForFootprintListVo(int total, List<Footprint> items) {
        this.total = total;
        this.items = items;
    }

    public DataForFootprintListVo() {
    }
}
