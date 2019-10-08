package com.cskaoyan.mall.bean;

public class GoodsCategoryAndBrand {
    private int categoryId;
    private int brandId;
    private int page;
    private int size;
    private int keyword;

    public int getKeyword() {
        return keyword;
    }

    public void setKeyword(int keyword) {
        this.keyword = keyword;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
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
}
