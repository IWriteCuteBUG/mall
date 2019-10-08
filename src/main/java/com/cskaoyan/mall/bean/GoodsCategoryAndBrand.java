package com.cskaoyan.mall.bean;

public class GoodsCategoryAndBrand {
    private int categoryId;
    private int brandId;
    private int page;
    private int size;
    private String keyword;
    private String sort;
    private String order;

    @Override
    public String toString() {
        return "GoodsCategoryAndBrand{" +
                "categoryId=" + categoryId +
                ", brandId=" + brandId +
                ", page=" + page +
                ", size=" + size +
                ", keyword=" + keyword +
                ", sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                '}';
    }

    public GoodsCategoryAndBrand(int categoryId, int brandId, int page, int size, String keyword, String sort, String order) {
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.page = page;
        this.size = size;
        this.keyword = keyword;
        this.sort = sort;
        this.order = order;
    }

    public GoodsCategoryAndBrand() {
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
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
