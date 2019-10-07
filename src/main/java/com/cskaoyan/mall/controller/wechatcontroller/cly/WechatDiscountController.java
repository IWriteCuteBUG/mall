package com.cskaoyan.mall.controller.wechatcontroller.cly;


import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Coupon;
import com.cskaoyan.mall.service.wechatservice.cly.CouponService;
import com.cskaoyan.mall.utils.wechatutils.cly.ReturnUtilCly;
import com.cskaoyan.mall.vo.wechatvo.cly.ForMyCouponList;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("wx/coupon")
public class WechatDiscountController {
    @Autowired
    CouponService couponService;

    /**
     * 查询个人主页中的优惠券
     * 我需要用户 ID 呀
     * @param status
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("mylist")
    public BaseRespVo<ForMyCouponList> queryMyCouponList(short status, int page, int size){
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        ForMyCouponList forMyCouponList = couponService.queryMyCouponList(status, page, size, userId);
        return ReturnUtilCly.back(forMyCouponList, "成功", 0);
    }

    /**
     * 根据兑换码兑换优惠券
     * 兑换成功后返回数据是什么？？？
     * @param map
     * @return
     */
    @RequestMapping("exchange")
    public BaseRespVo changeCoupon(@RequestBody Map map){
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        String code = (String) map.get("code");
        boolean flag = couponService.changeCoupon(userId, code);
        if(flag){
            return ReturnUtilCly.back(null, "成功", 0);
        }
        return ReturnUtilCly.back(null, "优惠券不正确", 742);
    }

    /**
     * 领取优惠券
     * @param map
     * @return
     */
    @RequestMapping("receive")
    public BaseRespVo receiveCoupon(@RequestBody Map map){
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        Integer couponId = (Integer) map.get("couponId");
        int flag = couponService.receiveCoupon(userId, couponId);
        if(flag == 0) {
            return ReturnUtilCly.back(null, "成功", 0);
        }else if (flag == 1){
            return ReturnUtilCly.back(null, "优惠券已经领取过", 740);
        }else {
            return ReturnUtilCly.back(null, "优惠券已领完", 740);
        }
    }

    /**
     * 查询所有优惠券
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("list")
    public BaseRespVo<ForMyCouponList> queryCouponList(int page, int size){
        ForMyCouponList forMyCouponList = couponService.queryCouponList(page, size);
        return ReturnUtilCly.back(forMyCouponList, "成功", 0);
    }

    @RequestMapping("selectlist")
    public BaseRespVo queryUsableCoupon(int cartId, int grouponRulesId){
        List<Coupon> couponList = couponService.queryUsableCoupon(cartId,grouponRulesId);
        return ReturnUtilCly.back(couponList, "成功", 0);
    }
}
