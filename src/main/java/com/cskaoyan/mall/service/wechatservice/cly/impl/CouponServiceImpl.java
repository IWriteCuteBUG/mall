package com.cskaoyan.mall.service.wechatservice.cly.impl;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.CartMapper;
import com.cskaoyan.mall.mapper.CouponMapper;
import com.cskaoyan.mall.mapper.CouponUserMapper;
import com.cskaoyan.mall.mapper.GoodsMapper;
import com.cskaoyan.mall.service.wechatservice.cly.CouponService;
import com.cskaoyan.mall.utils.wechatutils.cly.String2Number;
import com.cskaoyan.mall.vo.wechatvo.cly.ForMyCouponList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    CouponMapper couponMapper;

    @Autowired
    CouponUserMapper couponUserMapper;

    @Autowired
    CartMapper cartMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<Coupon> queryUsableCoupon(int cartId, int grouponRulesId) {
        //获取下单用户 ID
        Integer userId = cartMapper.selectUserId(cartId);
        //查询购物车中该用户勾选的所有商品 ID
        List<Cart> carts = cartMapper.selectGoodsId(userId);
        //获取预下单中所含的所有商品类目信息
        List<Integer> categoryIds = new ArrayList<>();
        List<Integer> goodsIds = new ArrayList<>();
        for (Cart cart : carts) {
            Goods goods = goodsMapper.selectCategoryId(cart.getGoodsId());
            categoryIds.add(goods.getCategoryId());
            goodsIds.add(goods.getId());
        }
        //获取该用户拥有的所有有效的优惠券 ID
        Date now = new Date();
        List<Coupon> couponList = new ArrayList<>();
        CouponUserExample couponUserExample = new CouponUserExample();
        CouponUserExample.Criteria criteriaCouponUser = couponUserExample.createCriteria();
        criteriaCouponUser.andUserIdEqualTo(userId);
        criteriaCouponUser.andStartTimeLessThan(now);
        criteriaCouponUser.andEndTimeGreaterThan(now);
        criteriaCouponUser.andStatusEqualTo((short)0);
        criteriaCouponUser.andDeletedEqualTo(false);
        List<CouponUser> couponUsers = couponUserMapper.selectByExample(couponUserExample);
        for (CouponUser couponUser : couponUsers) {
            Coupon coupon = couponMapper.selectByPrimaryKey(couponUser.getCouponId());
            couponList.add(coupon);
        }
        //判断哪一些优惠券可用
        for (Coupon coupon : couponList) {
            if(coupon.getGoodsType() == 0){
            }
            else if(coupon.getGoodsType() == 1){
                String[] goodsValue = coupon.getGoodsValue();
                List<Integer> integers = String2Number.string2Num(goodsValue);
                for (Integer categoryId : categoryIds) {
                    if(integers.contains(categoryId)){
                    }else {
                        couponList.remove(coupon);
                        break;
                    }
                }
            }else if(coupon.getGoodsType() == 2){
                String[] goodsValue = coupon.getGoodsValue();
                List<Integer> integers = String2Number.string2Num(goodsValue);
                for (Integer goodsId : goodsIds) {
                    if(integers.contains(goodsId)){
                    }else{
                        couponList.remove(coupon);
                        break;
                    }
                }
            }
        }
        return couponList;
    }

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
        forMyCouponList.setData(coupons);
        forMyCouponList.setCount(total);
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
