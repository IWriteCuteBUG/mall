package com.cskaoyan.mall.vo.goodsmanagervo;

import javax.validation.constraints.Min;

public class ForQueryComments {
    private int page;
    private int limit;
    private String sort;
    private String order;
    @Min(value = 0, message = "输入大于0的整数")
    private Integer userId;
    @Min(value = 0, message = "输入大于0的整数")
    private Integer valueId;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getValueId() {
        return valueId;
    }

    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }
}
