package com.cskaoyan.mall.vo.voSJB;

import com.cskaoyan.mall.bean.SearchHistory;

import java.util.List;

public class DataForSearchHistoryListVo {
    private int total;//total代表收藏总数
    private List<SearchHistory> items;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<SearchHistory> getItems() {
        return items;
    }

    public void setItems(List<SearchHistory> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "DataForSearchHistoryListVo{" +
                "total=" + total +
                ", items=" + items +
                '}';
    }

    public DataForSearchHistoryListVo(int total, List<SearchHistory> items) {
        this.total = total;
        this.items = items;
    }

    public DataForSearchHistoryListVo() {
    }
}
