package com.cskaoyan.mall.service.wechatservice.cly.impl;

import com.cskaoyan.mall.bean.Coupon;
import com.cskaoyan.mall.bean.CouponExample;
import com.cskaoyan.mall.bean.CouponUser;
import com.cskaoyan.mall.bean.CouponUserExample;
import com.cskaoyan.mall.mapper.CouponMapper;
import com.cskaoyan.mall.mapper.CouponUserMapper;
import com.cskaoyan.mall.service.wechatservice.cly.CouponService;
import com.cskaoyan.mall.vo.wechatvo.cly.ForMyCouponList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    CouponMapper couponMapper;

    @Autowired
    CouponUserMapper couponUserMapper;

    @Override
    public ForMyCouponList queryMyCouponList(short status, int page, int size, int userId) {
        PageHelper.startPage(page, size);
        /*CouponExample couponExample = new CouponExample();
        CouponExample.Criteria criteria = couponExample.createCriteria();
        criteria.andStatusEqualTo(status);
        List<Coupon> coupons = couponMapper.selectByExample(couponExample);
        PageInfo<Coupon> couponPageInfo = new PageInfo<>(coupons);
        long total = couponPageInfo.getTotal();
        ForMyCouponList forMyCouponList = new ForMyCouponList();
        forMyCouponList.setCount(total);
        forMyCouponList.setData(coupons);
        return forMyCouponList;*/
        List<Coupon> coupons = couponMapper.queryMyCouponList(status, userId);
        PageInfo<Coupon> couponPageInfo = new PageInfo<>(coupons);
        long total = couponPageInfo.getTotal();
        ForMyCouponList forMyCouponList = new ForMyCouponList();
        forMyCouponList.setCount(total);
        forMyCouponList.setData(coupons);
        return forMyCouponList;
    }

    @Override
    public boolean changeCoupon(int userId, String code) {
        CouponExample couponExample = new CouponExample();
        CouponExample.Criteria criteria = couponExample.createCriteria();
        criteria.andCodeEqualTo(code);
        List<Coupon> coupons = couponMapper.selectByExample(couponExample);
        if(coupons.isEmpty()){
            return false;
        }else{
            Date date = new Date();
            boolean deleted = false;
            for (Coupon coupon : coupons) {
                couponUserMapper.insertChangeCoupon(coupon, userId, date, deleted);
            }
            return true;
        }
    }

    @Override
    public int receiveCoupon(int userId, Integer couponId) {
        Coupon coupon = couponMapper.selectByPrimaryKey(couponId);
        //首先判断优惠券total
        Integer total = coupon.getTotal();
        if(total == 0) {
            //然后判断优惠券limit字段
            Short limit = coupon.getLimit();
            //limit为0，用户可以领取多张，直接发放
            if(limit == 0) {
                Date date = new Date();
                boolean deleted = false;
                couponUserMapper.insertChangeCoupon(coupon,userId,date,deleted);
                return 0;
            }else {
                //limit为1，用户只能有一张此优惠券
                //判断用户是否已经有此优惠券
                CouponUserExample couponUserExample = new CouponUserExample();
                CouponUserExample.Criteria criteria = couponUserExample.createCriteria();
                criteria.andCouponIdEqualTo(couponId);
                criteria.andUserIdEqualTo(userId);
                List<CouponUser> couponUsers = couponUserMapper.selectByExample(couponUserExample);
                //若没有则发放，并返回true
                if(couponUsers.isEmpty()) {
                    Date date = new Date();
                    boolean deleted = false;
                    couponUserMapper.insertChangeCoupon(coupon,userId,date,deleted);
                    return 0;
                }
                return 1;
            }
        }else if (total == -1){
            return 2;
        }else {
            //然后判断优惠券limit字段
            Short limit = coupon.getLimit();
            //limit为0，用户可以领取多张，直接发放
            if(limit == 0) {
                Date date = new Date();
                boolean deleted = false;
                couponUserMapper.insertChangeCoupon(coupon,userId,date,deleted);
                if(total == 1) {
                    updateTotal(coupon, total, 2);
                }else {
                    updateTotal(coupon, total, 1);
                }
                return 0;
            }else {
                //limit为1，用户只能有一张此优惠券
                //判断用户是否已经有此优惠券
                CouponUserExample couponUserExample = new CouponUserExample();
                CouponUserExample.Criteria criteria = couponUserExample.createCriteria();
                criteria.andUserIdEqualTo(userId);
                criteria.andCouponIdEqualTo(couponId);
                List<CouponUser> couponUsers = couponUserMapper.selectByExample(couponUserExample);
                //若没有则发放，并返回true
                if(couponUsers.isEmpty()) {
                    boolean deleted = false;
                    Date date = new Date();
                    couponUserMapper.insertChangeCoupon(coupon,userId,date,deleted);
                    if(total != 1) {
                        updateTotal(coupon, total, 1);
                    }else {
                        updateTotal(coupon, total, 2);
                    }
                    return 0;
                }
                return 1;
            }
        }
    }

    @Override
    public ForMyCouponList queryCouponList(int page, int size) {
        PageHelper.startPage(page, size);
        CouponExample couponExample = new CouponExample();
        CouponExample.Criteria criteria = couponExample.createCriteria();
        criteria.andIdIsNotNull();
        List<Coupon> coupons = couponMapper.selectByExample(couponExample);
        PageInfo<Coupon> couponPageInfo = new PageInfo<>(coupons);
        long total = couponPageInfo.getTotal();
        ForMyCouponList forMyCouponList = new ForMyCouponList();
        forMyCouponList.setCount(total);
        forMyCouponList.setData(coupons);
        return forMyCouponList;
    }


    private void updateTotal(Coupon coupon, Integer total, int reduce) {
        coupon.setTotal(total - reduce);
        couponMapper.updateByPrimaryKey(coupon);
    }

}
