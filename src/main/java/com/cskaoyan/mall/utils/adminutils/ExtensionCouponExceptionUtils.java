package com.cskaoyan.mall.utils.adminutils;


import com.cskaoyan.mall.bean.Coupon;
import com.cskaoyan.mall.exception.ExtensionCouponDiscountException;
import com.cskaoyan.mall.vo.adminvo.extensionvo.CouponObject;

import java.math.BigDecimal;
import java.util.Date;

public class ExtensionCouponExceptionUtils {

    public static Coupon couponDiscount(CouponObject coupon) throws ExtensionCouponDiscountException {
        Coupon couponTrue = new Coupon();
        try {
            couponTrue.setTotal(Integer.valueOf(coupon.getTotal()));
        } catch (Exception e) {
            throw new ExtensionCouponDiscountException("优惠卷数量参数输入有误");
        }
        if (couponTrue.getTotal() <= 0) {
            throw new ExtensionCouponDiscountException("优惠卷数量必须大于等于1");
        }
        if (coupon.getStartTime() != null && coupon.getEndTime() == null) {
            throw new ExtensionCouponDiscountException("请输入优惠卷失效时间");
        }
        if (coupon.getStartTime() == null && coupon.getEndTime() != null) {
            throw new ExtensionCouponDiscountException("请输入优惠卷生效时间");
        }
        if (coupon.getStartTime() == null && coupon.getEndTime() == null) {
            try {
                couponTrue.setDays(Short.valueOf(coupon.getDays()));
            } catch (Exception e) {
                throw new ExtensionCouponDiscountException("有效期参数输入有误");
            }
            if (couponTrue.getDays() <= 0) {
                throw new ExtensionCouponDiscountException("有效期时间必须大于等于1");
            }
        }
        if (coupon.getStartTime() != null && coupon.getEndTime() != null && !ExtensionStringUtils.isEmpty(coupon.getDays())) {
            throw new ExtensionCouponDiscountException("领劵相对时间与指定绝对时间，两种优惠卷生效模式只能选择其中一种");
        }
        if (coupon.getStartTime() != null) {
            if (!coupon.getStartTime().before(coupon.getEndTime())) {
                throw new ExtensionCouponDiscountException("优惠卷生效时间必须早于优惠卷失效时间");
            }
        }
        Date date = new Date();
       if(coupon.getStartTime()!=null){
           if (!date.before(coupon.getStartTime())) {
               throw new ExtensionCouponDiscountException("优惠卷生效时间必须晚于或等于当前时间");
           }
           if (!date.before(coupon.getEndTime())) {
               throw new ExtensionCouponDiscountException("优惠卷失效时间必须晚于当前时间");
           }
       }


        try {
            couponTrue.setLimit(Short.valueOf(coupon.getLimit()));
        } catch (Exception e) {
            throw new ExtensionCouponDiscountException("每人限领参数输入有误");
        }
        if (couponTrue.getLimit() <= 0) {
            throw new ExtensionCouponDiscountException("每人限领的数量必须大于等于1");
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
        int i = couponTrue.getMin().compareTo(BigDecimal.ZERO);
        if (i == 0 || i == -1) {
            throw new ExtensionCouponDiscountException("最低消费参数必须大于等于1");
        }
        try {
//            Long aLong = Long.valueOf(coupon.getDiscount());
            BigDecimal bigDecimal = new BigDecimal(coupon.getDiscount());
            couponTrue.setDiscount(bigDecimal);
        } catch (Exception e) {
            throw new ExtensionCouponDiscountException("满减金额参数输入有误");
        }
        int i1 = couponTrue.getDiscount().compareTo(BigDecimal.ZERO);
        if (i1 == 0 || i1 == -1) {
            throw new ExtensionCouponDiscountException("满减金额必须大于等于1");
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
