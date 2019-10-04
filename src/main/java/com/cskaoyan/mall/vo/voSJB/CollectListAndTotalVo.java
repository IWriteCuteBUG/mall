package com.cskaoyan.mall.vo.voSJB;

import com.cskaoyan.mall.bean.Collect;

import java.util.List;

public class CollectListAndTotalVo {
    private List<Collect> collectList;
    private int total;

    public CollectListAndTotalVo() {
    }

    public CollectListAndTotalVo(List<Collect> collectList, int total) {
        this.collectList = collectList;
        this.total = total;
    }

    public List<Collect> getCollectList() {
        return collectList;
    }

    public void setCollectList(List<Collect> collectList) {
        this.collectList = collectList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CollectListAndTotalVo{" +
                "collectList=" + collectList +
                ", total=" + total +
                '}';
    }


}
