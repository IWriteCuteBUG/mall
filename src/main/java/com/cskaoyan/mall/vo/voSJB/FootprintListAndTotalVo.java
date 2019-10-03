package com.cskaoyan.mall.vo.voSJB;

import com.cskaoyan.mall.bean.Footprint;

import java.util.List;

public class FootprintListAndTotalVo {
    private List<Footprint> footprintList;
    private int total;

    @Override
    public String toString() {
        return "FootprintListAndTotalVo{" +
                "footprintList=" + footprintList +
                ", total=" + total +
                '}';
    }

    public FootprintListAndTotalVo(List<Footprint> footprintList, int total) {
        this.footprintList = footprintList;
        this.total = total;
    }

    public FootprintListAndTotalVo() {
    }

    public List<Footprint> getFootprintList() {
        return footprintList;
    }

    public void setFootprintList(List<Footprint> footprintList) {
        this.footprintList = footprintList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
