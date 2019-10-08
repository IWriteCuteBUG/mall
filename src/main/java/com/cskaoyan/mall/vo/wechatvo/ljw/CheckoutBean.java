package com.cskaoyan.mall.vo.wechatvo.ljw;

import com.cskaoyan.mall.bean.Address;
import com.cskaoyan.mall.bean.OrderGoods;

import java.math.BigDecimal;
import java.util.List;

public class CheckoutBean {
    @Override
    public String toString() {

        return "CheckoutBean{" +
                "grouponRulesId=" + grouponRulesId +
                ", checkedAddress=" + checkedAddress +
                ", grouponPrice=" + grouponPrice +
                ", actualPrice=" + actualPrice +
                ", orderTotalPrice=" + orderTotalPrice +
                ", couponPrice=" + couponPrice +
                ", availableCouponLength=" + availableCouponLength +
                ", couponId=" + couponId +
                ", freightPrice=" + freightPrice +
                ", checkedGoodsList=" + checkedGoodsList +
                ", goodsTotalPrice=" + goodsTotalPrice +
                ", addressId=" + addressId +
                '}';
    }

    int grouponRulesId;    //团购活动id
    Address checkedAddress; //地址
    BigDecimal grouponPrice; //团购优惠价格
    double actualPrice; //实付价格
    double orderTotalPrice; //订单总价 =商品总价+运费-优惠价格-团购优惠价格
    double couponPrice;  //优惠价格
    int availableCouponLength; //团购持续时间
    int couponId;          //团购活动id
    double freightPrice;   //运费
    List<OrderGoods> checkedGoodsList;
    BigDecimal goodsTotalPrice; //商品总价
    int addressId;

    public BigDecimal getGrouponPrice() {
        return grouponPrice;
    }

    public void setGrouponPrice(BigDecimal grouponPrice) {
        this.grouponPrice = grouponPrice;
    }

    public int getGrouponRulesId() {
        return grouponRulesId;
    }

    public void setGrouponRulesId(int grouponRulesId) {
        this.grouponRulesId = grouponRulesId;
    }

    public Address getCheckedAddress() {
        return checkedAddress;
    }

    public void setCheckedAddress(Address checkedAddress) {
        this.checkedAddress = checkedAddress;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public double getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(double orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public double getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(double couponPrice) {
        this.couponPrice = couponPrice;
    }

    public int getAvailableCouponLength() {
        return availableCouponLength;
    }

    public void setAvailableCouponLength(int availableCouponLength) {
        this.availableCouponLength = availableCouponLength;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public double getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(double freightPrice) {
        this.freightPrice = freightPrice;
    }

    public List<OrderGoods> getCheckedGoodsList() {
        return checkedGoodsList;
    }

    public void setCheckedGoodsList(List<OrderGoods> checkedGoodsList) {
        this.checkedGoodsList = checkedGoodsList;
    }

    public BigDecimal getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public void setGoodsTotalPrice(BigDecimal goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
}
