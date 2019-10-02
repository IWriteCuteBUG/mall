package com.cskaoyan.mall.vo.extensionvo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class GrouponRulesErr<T> {
    private Integer id;

    private Integer goodsId;

    private String goodsName;

    private String picUrl;

    private T discount;

    private T discountMember;

    private Date addTime;

    private Date updateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expireTime;

    private Boolean deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public T getDiscount() {
        return discount;
    }

    public void setDiscount(T discount) {
        this.discount = discount;
    }

    public T getDiscountMember() {
        return discountMember;
    }

    public void setDiscountMember(T discountMember) {
        this.discountMember = discountMember;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
