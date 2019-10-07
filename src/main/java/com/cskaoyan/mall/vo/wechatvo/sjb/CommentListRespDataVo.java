package com.cskaoyan.mall.vo.wechatvo.sjb;

import java.util.List;

public class CommentListRespDataVo<T> {
    private int count;
    private int currentPage;
    private List<T> data;

    @Override
    public String toString() {
        return "CommentListRespDataVo{" +
                "count=" + count +
                ", currentPage=" + currentPage +
                ", data=" + data +
                '}';
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public CommentListRespDataVo(int count, int currentPage, List<T> data) {
        this.count = count;
        this.currentPage = currentPage;
        this.data = data;
    }

    public CommentListRespDataVo() {
    }
}
