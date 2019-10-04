package com.cskaoyan.mall.vo.goodsmanagervo;

import java.util.List;

public class CommentListVo<Comment> {
    private long total;
    private List<Comment> items;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<Comment> getItems() {
        return items;
    }

    public void setItems(List<Comment> items) {
        this.items = items;
    }
}
