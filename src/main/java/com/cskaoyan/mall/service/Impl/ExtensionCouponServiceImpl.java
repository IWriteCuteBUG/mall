package com.cskaoyan.mall.service.Impl;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.CouponMapper;
import com.cskaoyan.mall.mapper.CouponUserMapper;
import com.cskaoyan.mall.service.ExtensionCouponService;
import com.cskaoyan.mall.vo.extensionvo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtensionCouponServiceImpl implements ExtensionCouponService {

    @Autowired
    CouponMapper couponMapper;

    @Autowired
    CouponUserMapper couponUserMapper;
    @Override
    public BaseRespVo queryCroupons(FromCoupon fromCoupon) {
        PageHelper.startPage(fromCoupon.getPage(), fromCoupon.getLimit());
        int type = fromCoupon.getType();
        int status = fromCoupon.getStatus();
        String name = fromCoupon.getName();
        CouponExample couponExample = new CouponExample();
        CouponExample.Criteria criteria = couponExample.createCriteria();
        List<Coupon> coupons = null;
        if (type != -1 ) {
            criteria = criteria.andTypeEqualTo((short)type);
        }

        if (status != -1 ) {
            criteria = criteria.andStatusEqualTo((short) status);
        }

        if (name != null) {
            criteria.andNameEqualTo(fromCoupon.getName());
        }

        coupons = couponMapper.selectByExample(couponExample);
        PageInfo<Coupon> pageInfo = new PageInfo<>(coupons);
        int total = (int) pageInfo.getTotal();
        return BaseRespVo.baseRespListOk(total,coupons);
    }

    @Override
    public BaseRespVo createCroupons(Coupon coupon) {
        int i = couponMapper.insertSelective(coupon);
        BaseRespVo baseRespVo = BaseRespVo.baseRespOk(coupon);
        return baseRespVo;
    }

    @Override
    public BaseRespVo selectCouponById(int id) {
        Coupon coupon = couponMapper.selectByPrimaryKey(id);
        BaseRespVo baseRespVo = BaseRespVo.baseRespOk(coupon);
        return baseRespVo;
    }

    @Override
    public BaseRespVo selectCouponUserListByCouponId(FromRequestKey fromRequestKey, FromUserCoupon fromUserCoupon) {
        PageHelper.startPage(fromRequestKey.getPage(), fromRequestKey.getLimit());
        CouponUserExample couponUserExample = new CouponUserExample();
        CouponUserExample.Criteria criteria = couponUserExample.createCriteria();
        int status = fromUserCoupon.getStatus();
        Integer userId = fromUserCoupon.getUserId();
        if (userId != null) {
            criteria = criteria.andUserIdEqualTo(userId);
        }
        if (status != -1) {
            criteria = criteria.andStatusEqualTo((short) status);
        }
        List<CouponUser> couponUsers = couponUserMapper.selectByExample(couponUserExample);
        PageInfo<CouponUser> couponUserPageInfo = new PageInfo<>(couponUsers);
        int total = (int) couponUserPageInfo.getTotal();
        return BaseRespVo.baseRespListOk(total,couponUsers);
    }
//  修改优惠卷
    @Override
    public BaseRespVo createUpdate(Coupon coupon) {
        int update = couponMapper.updateByPrimaryKey(coupon);
        return BaseRespVo.baseRespOk(coupon);
    }

//  删除优惠卷
    @Override
    public BaseRespVo deleteCoupon(Coupon coupon) {
        int i = couponMapper.deleteByPrimaryKey(coupon.getId());
        return BaseRespVo.baseRespOk("");
    }


}
