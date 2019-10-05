package com.cskaoyan.mall.vo.wechatvo.dhd;

import com.cskaoyan.mall.bean.Goods;

import java.util.List;

public class CollectListVo {
    List<Goods> collectList;
    int totalPages;

    public List<Goods> getCollectList() {
        return collectList;
    }

    public void setCollectList(List<Goods> collectList) {
        this.collectList = collectList;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public String toString() {
        return "CollectListVo{" +
                "collectList=" + collectList +
                ", totalPages=" + totalPages +
                '}';
    }
}
