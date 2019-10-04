package com.cskaoyan.mall.vo.goodsmanagervo;

import java.util.List;

public class GoodsListVo<Goods> {

    long total;
    List<Goods> items;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<Goods> getItems() {
        return items;
    }

    public void setItems(List<Goods> items) {
        this.items = items;
    }
}
