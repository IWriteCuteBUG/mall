package com.cskaoyan.mall.vo.wechatvo.cly;

import com.cskaoyan.mall.bean.Coupon;

import java.util.List;

public class ForMyCouponList {
    private long count;
    private List<Coupon> data;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<Coupon> getData() {
        return data;
    }

    public void setData(List<Coupon> data) {
        this.data = data;
    }
}
