package com.cskaoyan.mall.vo.voSJB;

import com.cskaoyan.mall.bean.Feedback;

import java.util.List;

public class DataForFeedbackListVo {
    private int total;//total代表收藏总数
    private List<Feedback> items;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Feedback> getItems() {
        return items;
    }

    public void setItems(List<Feedback> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "DataForFeedbackListVo{" +
                "total=" + total +
                ", items=" + items +
                '}';
    }

    public DataForFeedbackListVo(int total, List<Feedback> items) {
        this.total = total;
        this.items = items;
    }

    public DataForFeedbackListVo() {
    }
}
