package com.cskaoyan.mall.service.adminservice;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Coupon;
import com.cskaoyan.mall.exception.ExtensionCouponDiscountException;
import com.cskaoyan.mall.vo.adminvo.extensionvo.*;

public interface ExtensionCouponService {

    BaseRespVo queryCroupons(FromCoupon fromCoupon);

    BaseRespVo createCroupons(Coupon couponObject) throws ExtensionCouponDiscountException;

    BaseRespVo selectCouponById(int id);

    BaseRespVo selectCouponUserListByCouponId(FromRequestKey fromRequestKey, FromUserCoupon fromUserCoupon);

    BaseRespVo createUpdate(Coupon coupon);

    BaseRespVo deleteCoupon(Coupon coupon);
}
