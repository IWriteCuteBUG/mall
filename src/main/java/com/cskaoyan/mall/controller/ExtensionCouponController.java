package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Coupon;
import com.cskaoyan.mall.exception.ExtensionCouponDiscountException;
import com.cskaoyan.mall.service.ExtensionCouponService;
import com.cskaoyan.mall.vo.extensionvo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("admin/coupon")
public class ExtensionCouponController {
    @Autowired
    ExtensionCouponService couponService;


    @RequestMapping("list")
    public BaseRespVo couponList(FromCoupon fromCoupon) {
        BaseRespVo baseRespVo = couponService.queryCroupons(fromCoupon);
        return baseRespVo;
    }

//    创建优惠卷
    @RequestMapping("create")
    public BaseRespVo couponCreate(@RequestBody Coupon couponObject) throws ExtensionCouponDiscountException {
        BaseRespVo baseRespVo = couponService.createCroupons(couponObject);
        return baseRespVo;
    }
//    修改优惠卷
    @RequestMapping("update")
    public BaseRespVo couponUpdate(@RequestBody Coupon coupon) {
        BaseRespVo baseRespVo = couponService.createUpdate(coupon);
        return baseRespVo;
    }

//    删除优惠卷
    @RequestMapping("delete")
    public BaseRespVo couponDelete (@RequestBody Coupon coupon) {
        BaseRespVo baseRespVo = couponService.deleteCoupon(coupon);
        return baseRespVo;
    }

    @RequestMapping("listuser")
    public BaseRespVo couponListuser (FromRequestKey fromRequestKey, FromUserCoupon fromUserCoupon) {
        BaseRespVo baseRespVo = couponService.selectCouponUserListByCouponId(fromRequestKey,fromUserCoupon);
        return baseRespVo;
    }

//    查看优惠卷
    @RequestMapping("read")
    public BaseRespVo couponCreate(int id) {
        BaseRespVo baseRespVo = couponService.selectCouponById(id);
        return baseRespVo;
    }


}
