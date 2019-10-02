package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Coupon;
import com.cskaoyan.mall.vo.extensionvo.FromAdvert;
import com.cskaoyan.mall.vo.extensionvo.FromCoupon;
import com.cskaoyan.mall.vo.extensionvo.FromRequestKey;
import com.cskaoyan.mall.vo.extensionvo.FromUserCoupon;

public interface ExtensionCouponService {

    BaseRespVo queryCroupons(FromCoupon fromCoupon);

    BaseRespVo createCroupons(Coupon coupon);

    BaseRespVo selectCouponById(int id);

    BaseRespVo selectCouponUserListByCouponId(FromRequestKey fromRequestKey, FromUserCoupon fromUserCoupon);

    BaseRespVo createUpdate(Coupon coupon);

    BaseRespVo deleteCoupon(Coupon coupon);
}
