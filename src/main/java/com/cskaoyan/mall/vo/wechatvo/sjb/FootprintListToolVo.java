package com.cskaoyan.mall.vo.wechatvo.sjb;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class FootprintListToolVo {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;//来自footprint
    private String brief;//来自goods
    private int goodsId;//来自footprint
    private int id;//来自footprint
    private String name;//来自goods
    private String picUrl;//来自goods
    private double retailPrice;//来自goods

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    @Override
    public String toString() {
        return "FootprintListToolVo{" +
                "addTime=" + addTime +
                ", brief='" + brief + '\'' +
                ", goodsId=" + goodsId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", retailPrice=" + retailPrice +
                '}';
    }

    public FootprintListToolVo() {
    }

    public FootprintListToolVo(Date addTime, String brief, int goodsId, int id, String name, String picUrl, double retailPrice) {
        this.addTime = addTime;
        this.brief = brief;
        this.goodsId = goodsId;
        this.id = id;
        this.name = name;
        this.picUrl = picUrl;
        this.retailPrice = retailPrice;
    }
}
