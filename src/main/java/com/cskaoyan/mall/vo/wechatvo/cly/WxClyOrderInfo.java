package com.cskaoyan.mall.vo.wechatvo.cly;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class WxClyOrderInfo {
    private Integer id;

    private String orderSn;

    //private Short orderStatus;

    private String consignee;

    private String mobile;

    private String address;

    //private String message;

    private BigDecimal goodsPrice;

    private BigDecimal freightPrice;

    private BigDecimal couponPrice;

    //private BigDecimal integralPrice;

    //private BigDecimal grouponPrice;

    //private BigDecimal orderPrice;

    private BigDecimal actualPrice;

    //private String payId;
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    //private Date payTime;

    //private String shipSn;

    //private String shipChannel;
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    //private Date shipTime;
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    //private Date confirmTime;

    //private Short comments;
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    //private Date endTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date addTime;
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    //private Date updateTime;

    //private Boolean deleted;

    private String orderStatusText;
    private WxClyHandleOption handleOption;

    public String getOrderStatusText() {
        return orderStatusText;
    }

    public void setOrderStatusText(String orderStatusText) {
        this.orderStatusText = orderStatusText;
    }

    public WxClyHandleOption getHandleOption() {
        return handleOption;
    }

    public void setHandleOption(WxClyHandleOption handleOption) {
        this.handleOption = handleOption;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
    }

    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
