package com.cskaoyan.mall.vo.wechatvo.tongsong;

import java.util.List;

public class OrderVoForReturn {
    private List data;
    private int count;
    private int totalPages;

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
