package com.cskaoyan.mall.bean;

public class SubmitOrders {
    private int addressId;
    private int cartId;
    private int couponId;
    private int grouponLinkId;
    private int grouponRulesI;
    private String message;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public int getGrouponLinkId() {
        return grouponLinkId;
    }

    public void setGrouponLinkId(int grouponLinkId) {
        this.grouponLinkId = grouponLinkId;
    }

    public int getGrouponRulesI() {
        return grouponRulesI;
    }

    public void setGrouponRulesI(int grouponRulesI) {
        this.grouponRulesI = grouponRulesI;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}