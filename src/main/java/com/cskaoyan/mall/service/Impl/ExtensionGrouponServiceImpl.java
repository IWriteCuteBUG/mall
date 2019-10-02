package com.cskaoyan.mall.service.Impl;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.GoodsMapper;
import com.cskaoyan.mall.mapper.GrouponMapper;
import com.cskaoyan.mall.mapper.GrouponRulesMapper;
import com.cskaoyan.mall.service.ExtensionGrouponService;
import com.cskaoyan.mall.vo.extensionvo.AdvertList;
import com.cskaoyan.mall.vo.extensionvo.FromRequestKey;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ExtensionGrouponServiceImpl implements ExtensionGrouponService {
    @Autowired
    GrouponRulesMapper grouponRulesMapper;
    @Autowired
    GoodsMapper goodsMapper;
    @Override
    public BaseRespVo queryGrouponListByGoodsId(FromRequestKey fromRequestKey, Integer goodsId) {
        PageHelper.startPage(fromRequestKey.getPage(), fromRequestKey.getLimit());
        List<GrouponRules> grouponRules = null;
        GrouponRulesExample grouponRulesExample = new GrouponRulesExample();
        GrouponRulesExample.Criteria criteria = grouponRulesExample.createCriteria();
        if (goodsId != null) {
            criteria.andGoodsIdEqualTo(goodsId);
            grouponRules = grouponRulesMapper.selectByExample(grouponRulesExample);
        }
        if (goodsId == null) {
            grouponRules = grouponRulesMapper.selectByExample(grouponRulesExample);
        }
        PageInfo<GrouponRules> pageInfo = new PageInfo<>(grouponRules);
        int total = (int) pageInfo.getTotal();
        AdvertList advertList = new AdvertList();
        advertList.setTotal(total);
        advertList.setItems(grouponRules);
        BaseRespVo baseRespVo = BaseRespVo.baseRespOk(advertList);
        return baseRespVo;
    }

    @Override
    public BaseRespVo queryGrouponCreate(GrouponRules grouponRules) {
        Goods goods = getGrouponByGoodsId(grouponRules);
        BaseRespVo baseRespVo = null;
        if (goods == null) {
            baseRespVo = BaseRespVo.baseRespErr(402, "参数错误");
        }
        if (goods != null) {
            grouponRules.setGoodsName(goods.getName());
            grouponRules.setPicUrl(goods.getPicUrl());
            Date addTime = new Date();
            grouponRules.setAddTime(addTime);
            grouponRules.setUpdateTime(addTime);
            grouponRules.setDeleted(false);
            int i = grouponRulesMapper.insertSelective(grouponRules);
            baseRespVo = BaseRespVo.baseRespOk(grouponRules);
        }

        return baseRespVo;
    }

    private Goods getGrouponByGoodsId(GrouponRules grouponRules) {
        Integer goodsId = grouponRules.getGoodsId();
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        return goods;
    }

    @Override
    public BaseRespVo queryGrouponDelete(GrouponRules grouponRules) {
        int i = grouponRulesMapper.deleteByPrimaryKey(grouponRules.getId());
        BaseRespVo baseRespVo = BaseRespVo.baseRespOk("");
        return baseRespVo;
    }

    @Override
    public BaseRespVo queryGrouponUpdate(GrouponRules grouponRules) {
        Goods goods = getGrouponByGoodsId(grouponRules);
        if (goods == null) {
            return BaseRespVo.baseRespErr(402, "参数值不对");
        }
        int update = grouponRulesMapper.updateByPrimaryKey(grouponRules);
        return BaseRespVo.baseRespOk(grouponRules);
    }
}
