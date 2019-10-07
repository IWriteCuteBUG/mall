package com.cskaoyan.mall.vo.wechatvo.sjb;

import java.util.List;

public class FootprintAndGoodsDataToolVo<T> {
    private List<T> footprintList;
    private int totalPages;

    @Override
    public String toString() {
        return "FootprintAndGoodsDataToolVo{" +
                "footprintList=" + footprintList +
                ", totalPages=" + totalPages +
                '}';
    }

    public List<T> getFootprintList() {
        return footprintList;
    }

    public void setFootprintList(List<T> footprintList) {
        this.footprintList = footprintList;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public FootprintAndGoodsDataToolVo(List<T> footprintList, int totalPages) {
        this.footprintList = footprintList;
        this.totalPages = totalPages;
    }

    public FootprintAndGoodsDataToolVo() {
    }
}
