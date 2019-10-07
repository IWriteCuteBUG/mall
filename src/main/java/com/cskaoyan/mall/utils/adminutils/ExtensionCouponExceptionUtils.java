package com.cskaoyan.mall.utils.adminutils;


import com.cskaoyan.mall.bean.Coupon;
import com.cskaoyan.mall.exception.ExtensionCouponDiscountException;
import com.cskaoyan.mall.vo.adminvo.extensionvo.CouponObject;

import java.math.BigDecimal;

public class ExtensionCouponExceptionUtils {

    public static Coupon couponDiscount(CouponObject coupon) throws ExtensionCouponDiscountException {
        Coupon couponTrue = new Coupon();
        try {
            couponTrue.setTotal(Integer.valueOf(coupon.getTotal()));
        } catch (Exception e) {
            throw new ExtensionCouponDiscountException("优惠卷数量参数输入有误");
        }
        try {
            couponTrue.setDays(Short.valueOf(coupon.getDays()));
        } catch (Exception e) {
            throw new ExtensionCouponDiscountException("有效期参数输入有误");
        }
        try {
            couponTrue.setLimit(Short.valueOf(coupon.getLimit()));
        } catch (Exception e) {
            throw new ExtensionCouponDiscountException("每人限领参数输入有误");
        }

        try {
//            coupon.getMin()
//            Long aLong = Long.valueOf(coupon.getMin());
//            couponTrue.setMin(BigDecimal.valueOf(aLong));
            BigDecimal bigDecimal = new BigDecimal(coupon.getMin());
//            couponTrue.setMin(BigDecimal.valueOf(bigDecimal));
            couponTrue.setMin(bigDecimal);
        } catch (Exception e) {
            throw new ExtensionCouponDiscountException("最低消费参数输入有误");
        }
        try {
            Long aLong = Long.valueOf(coupon.getDiscount());
            couponTrue.setDiscount(BigDecimal.valueOf(aLong) );
        } catch (Exception e) {
            throw new ExtensionCouponDiscountException("满减金额参数输入有误");
        }
        couponTrue.setId(coupon.getId());
        couponTrue.setName(coupon.getName());
        couponTrue.setDesc(coupon.getDesc());
        couponTrue.setTag(coupon.getTag());
        couponTrue.setStatus(coupon.getStatus());
        couponTrue.setType(coupon.getType());
        couponTrue.setGoodsType(coupon.getGoodsType());
        couponTrue.setGoodsValue(coupon.getGoodsValue());
        couponTrue.setCode(coupon.getCode());
        couponTrue.setStartTime(coupon.getStartTime());
        couponTrue.setEndTime(coupon.getEndTime());
        couponTrue.setDeleted(coupon.getDeleted());
        return couponTrue;
    }
}
