package com.cskaoyan.mall.vo.adminvo.voLJW;

public class Refund {
    private  int orderId;
    private  int refundMoney;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getRefundMoney() {
        return refundMoney;
    }

    public void setRefundMoney(int refundMoney) {
        this.refundMoney = refundMoney;
    }
}
