package com.cskaoyan.mall.service.wechatservice.zyp.impl;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.*;
import com.cskaoyan.mall.service.wechatservice.zyp.WechatGrouponService;
import com.cskaoyan.mall.utils.wechatutils.zyp.HandleOptionUtils;
import com.cskaoyan.mall.utils.wechatutils.zyp.OrdersStatusUtils;
import com.cskaoyan.mall.vo.wechatvo.zyp.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.shiro.SecurityUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeChatGrouponServiceImpl implements WechatGrouponService {
    @Autowired
    GrouponMapper grouponMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    OrderGoodsMapper orderGoodsMapper;
    @Autowired
    GrouponRulesMapper grouponRulesMapper;
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public BaseRespVo queryGrouponByShowType(int showType) {

//        int userId = 1;
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");


        GrouponExample grouponExample = new GrouponExample();
        GrouponExample.Criteria criteria = grouponExample.createCriteria();
        if (showType == 0) {
            criteria.andCreatorUserIdEqualTo(userId).andUserIdEqualTo(userId);
        }
        if (showType == 1) {
            criteria.andUserIdEqualTo(userId);
        }
        List<Groupon> groupons = grouponMapper.selectByExample(grouponExample);
        List<MyGrounpVo> myGrounpVos = new ArrayList<>();
        for (Groupon groupon : groupons) {
            MyGrounpVo myGrounpVo = new MyGrounpVo();
            Integer orderId = groupon.getOrderId();
            OrderExample orderExample = new OrderExample();
            orderExample.createCriteria().andOrderSnEqualTo(orderId.toString());
            List<Order> orderList = orderMapper.selectByExample(orderExample);
            Order order = orderList.get(0);
//            订单状态
            String orderStatusText = OrdersStatusUtils.statusId4Status(order.getOrderStatus());
            myGrounpVo.setOrderStatusText(orderStatusText);
//            创建团购的用户
            User user = userMapper.selectByPrimaryKey(groupon.getCreatorUserId());
            myGrounpVo.setCreator(user.getNickname());
            myGrounpVo.setGroupon(groupon);
            myGrounpVo.setOrderId(orderId);
            myGrounpVo.setOrderSn(order.getOrderSn());
            myGrounpVo.setActualPrice(order.getActualPrice());
//            参与团购的人数
            int joinerCount = grouponMapper.selectJoinerCountByRuleId(groupon.getRulesId());

            myGrounpVo.setJoinerCount(joinerCount);

//            商品列表
            OrderGoodsExample orderGoodsExample = new OrderGoodsExample();
            orderGoodsExample.createCriteria().andOrderIdEqualTo(orderId);
            List<OrderGoods> orderGoods = orderGoodsMapper.selectByExample(orderGoodsExample);
            /*List<GrouponGoodsListVo> orderGoods = new ArrayList<>();
            GrouponGoodsListVo grouponListGoodVo = new GrouponGoodsListVo();
            orderGoods.add(grouponListGoodVo);*/
            myGrounpVo.setGoodsList(orderGoods);
//            团购规则
            GrouponRules grouponRules = grouponRulesMapper.selectByPrimaryKey(groupon.getRulesId());
            myGrounpVo.setRules(grouponRules);
//            id
            myGrounpVo.setId(groupon.getId());
            if (showType == 0) {
                myGrounpVo.setIsCreator(true);
            }
            if (showType == 1 && groupon.getCreatorUserId() != groupon.getUserId()) {
                myGrounpVo.setIsCreator(false);
            }
            if (showType == 1 && groupon.getCreatorUserId() == groupon.getUserId()) {
                myGrounpVo.setIsCreator(true);
            }
//            未完成
            HandleOption handleOption = HandleOptionUtils.getHandleOption(groupon);
            myGrounpVo.setHandleOption(handleOption);
            myGrounpVos.add(myGrounpVo);
        }
        MyGroupBaseVo<Object> myGroupBaseVo = new MyGroupBaseVo<>();
        myGroupBaseVo.setCount(groupons.size());
        myGroupBaseVo.setData(myGrounpVos);
        return BaseRespVo.baseRespOk(myGroupBaseVo);
    }

    @Override
    public BaseRespVo queryGrouponDetailByShowType(Integer grouponOnId) {
        GrouponDetailVo grouponDetailVo = new GrouponDetailVo();
//      发起团购者信息
        Creator creator = new Creator();
        Groupon groupon = grouponMapper.selectByPrimaryKey(grouponOnId);
        Integer creatorUserId = groupon.getCreatorUserId();
        User user = userMapper.selectByPrimaryKey(creatorUserId);
        creator.setAvatar(user.getAvatar());
        creator.setNickname(user.getNickname());
        grouponDetailVo.setCreator(creator);
        grouponDetailVo.setGroupon(groupon);
//      团购者信息

        GrouponExample grouponExample = new GrouponExample();
        grouponExample.createCriteria().andGrouponIdEqualTo(groupon.getGrouponId()).andRulesIdEqualTo(groupon.getRulesId());
        List<Groupon> groupons = grouponMapper.selectByExample(grouponExample);
        ArrayList<Joiners> joiners = new ArrayList<>();
        for (Groupon grouponFor : groupons) {
            Joiners joiner = new Joiners();
            Integer userId = grouponFor.getUserId();
            User joinUser = userMapper.selectByPrimaryKey(userId);
            joiner.setAvatar(joinUser.getAvatar());
            joiner.setNickname(joinUser.getNickname());
            joiners.add(joiner);
        }
        grouponDetailVo.setJoiners(joiners);

//      订单信息
        GrouponGoodInfo grouponGoodInfo = new GrouponGoodInfo();
        Order order = orderMapper.selectByPrimaryKey(groupon.getOrderId());
//        Order order = orderMapper.queryGrouponGoodInfosBy(groupon.getOrderId());

        grouponGoodInfo.setOrderSn(order.getOrderSn());
        grouponGoodInfo.setConsignee(order.getConsignee());
        grouponGoodInfo.setAddress(order.getAddress());
        grouponGoodInfo.setAddTime(order.getAddTime());
        grouponGoodInfo.setActualPrice(order.getActualPrice());
        grouponGoodInfo.setMobile(order.getMobile());
        grouponGoodInfo.setGoodsPrice(order.getGoodsPrice());
        grouponGoodInfo.setFreightPrice(order.getFreightPrice());
        grouponGoodInfo.setOrderStatusText(OrdersStatusUtils.statusId4Status(order.getOrderStatus()));
        grouponGoodInfo.setId(order.getId());
        grouponGoodInfo.setHandleOption(HandleOptionUtils.getHandleOption(order));
        grouponDetailVo.setOrderInfo(grouponGoodInfo);

//      商品详情

//        List<OrderGoods> orderGoods = orderGoodsMapper.queryOrdersGoodsByOrderId(groupon.getOrderId());
        OrderGoodsExample orderGoodsExample = new OrderGoodsExample();
        orderGoodsExample.createCriteria().andOrderIdEqualTo(groupon.getOrderId());
        List<OrderGoods> orderGoods = orderGoodsMapper.selectByExample(orderGoodsExample);

        grouponDetailVo.setOrderGoods(orderGoods);

//      团购规则
        GrouponRules grouponRules = grouponRulesMapper.selectByPrimaryKey(groupon.getRulesId());
        grouponDetailVo.setRules(grouponRules);

        grouponDetailVo.setLinkGrouponId(grouponOnId);
        return BaseRespVo.baseRespOk(grouponDetailVo);
    }

    @Override
    public BaseRespVo queryGrouponlist(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<GrouponListVo> grouponListVos = new ArrayList<>();
        List<GrouponRules> grouponRules = grouponRulesMapper.selectByExample(new GrouponRulesExample());
        for (GrouponRules grouponRule : grouponRules) {
            GrouponListVo grouponListVo = new GrouponListVo();
            Goods goods = goodsMapper.selectByPrimaryKey(grouponRule.getGoodsId());
            BigDecimal counterPrice = goods.getCounterPrice();
            BigDecimal discount = grouponRule.getDiscount();
            grouponListVo.setGroupon_price(counterPrice.subtract(discount));
            GrouponListGoodVo grouponListGoodVo = new GrouponListGoodVo();
            grouponListGoodVo.setBrief(goods.getBrief());
            grouponListGoodVo.setId(goods.getId());
            grouponListGoodVo.setName(goods.getName());
            grouponListGoodVo.setPicUrl(goods.getPicUrl());
            grouponListGoodVo.setCounterPrice(goods.getCounterPrice());
            grouponListGoodVo.setRetailPrice(goods.getRetailPrice());
            grouponListVo.setGoods(grouponListGoodVo);
            grouponListVo.setGroupon_member(grouponRule.getDiscountMember());
            grouponListVos.add(grouponListVo);
        }
        PageInfo<GrouponListVo> pageInfo = new PageInfo<>(grouponListVos);
        MyGroupBaseVo<Object> myGroupBaseVo = new MyGroupBaseVo<>();
        myGroupBaseVo.setData(grouponListVos);
        myGroupBaseVo.setCount((int)pageInfo.getTotal());
        return BaseRespVo.baseRespOk(myGroupBaseVo);
    }
}
