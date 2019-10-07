package com.cskaoyan.mall.vo.wechatvo.sjb;

public class GoodsSearchListReqVo {
    //输入参数校验
    private String keyword;
    private int page;
    private int size;
    private String sort;
    private String order;
    private int categoryId;

    @Override
    public String toString() {
        return "GoodsSearchListReqVo{" +
                "keyword='" + keyword + '\'' +
                ", page=" + page +
                ", size=" + size +
                ", sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }

    public GoodsSearchListReqVo() {
    }

    public GoodsSearchListReqVo(String keyword, int page, int size, String sort, String order, int categoryId) {
        this.keyword = keyword;
        this.page = page;
        this.size = size;
        this.sort = sort;
        this.order = order;
        this.categoryId = categoryId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
