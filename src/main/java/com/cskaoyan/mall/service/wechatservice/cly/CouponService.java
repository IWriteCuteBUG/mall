package com.cskaoyan.mall.service.wechatservice.cly;

import com.cskaoyan.mall.bean.Coupon;
import com.cskaoyan.mall.vo.wechatvo.cly.ForMyCouponList;

import java.util.List;

public interface CouponService {
    ForMyCouponList queryMyCouponList(short status, int page, int size, int userId);

    boolean changeCoupon(int userId, String code);

    int receiveCoupon(int userId, Integer couponId);

    ForMyCouponList queryCouponList(int page, int size);

    List<Coupon> queryUsableCoupon(int cartId, int grouponRulesId);
}
