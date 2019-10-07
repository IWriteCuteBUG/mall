package com.cskaoyan.mall.service.wechatservice.ljw.impl;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.GoodsMapper;
import com.cskaoyan.mall.mapper.OrderGoodsMapper;
import com.cskaoyan.mall.mapper.OrderMapper;
import com.cskaoyan.mall.service.wechatservice.ljw.OrderService;
import com.cskaoyan.mall.utils.wechatutils.ljw.OrdStaUtils;
import org.apache.logging.log4j.spi.LoggerContextKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Service
public class OrderServiceImply implements OrderService {


    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderGoodsMapper orderGoodsMapper;
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public BaseRespVo orderList(int showType, int page, int size) {
        int userid = 1;
        //mybatis查询准备
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andUserIdEqualTo(userid);
        //如果不是获取所有订单，则还要通过showType添加附加条件
        if (showType != 0) {
            criteria.andOrderStatusEqualTo(OrdStaUtils.getOrder_status(showType));
        }
        List<Order> orderList = orderMapper.selectByExample(orderExample);
        //对新增字段进行赋值
        for (Order order : orderList) {
            order.setisGroupin(order.getCouponPrice() != new BigDecimal(0));
            order.setOrderStatusText(OrdStaUtils.getStrSatus(order.getOrderStatus()));
            OrderGoodsExample orderGoodsExample = new OrderGoodsExample();
            OrderGoodsExample.Criteria orderGoodsExampleCriteria = orderGoodsExample.createCriteria();
            orderGoodsExampleCriteria.andOrderIdEqualTo(order.getId());
            //获取订单商品
            List<OrderGoods> orderGoodsList = orderGoodsMapper.selectByExample(orderGoodsExample);
            List<Goods> goodsList = new ArrayList<>();
            for (OrderGoods orderGoods : orderGoodsList) {
                goodsList.add(goodsMapper.selectByPrimaryKey(orderGoods.getGoodsId()));
            }

            order.setGoodsList(goodsList);
            //获取状态码进行handleOption的赋值
            short status = order.getOrderStatus();
            order.getHandleOption().setPay(status > 101);
            order.getHandleOption().setConfirm(status == 301);
            //系统收货或者确认收货之后可以再次购买，删除订单,进行评论,
            boolean isConfirm = size >= 401;

            order.getHandleOption().setRebuy(isConfirm);
            order.getHandleOption().setDelete(isConfirm);
            order.getHandleOption().setComment(isConfirm);
            //确认收货不能退款，不能取消订单
            order.getHandleOption().setCancel(!isConfirm);
            order.getHandleOption().setRefund(!isConfirm);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("count", orderList.size());
        hashMap.put("data", orderList);
        hashMap.put("totalPages", orderList.size() / size);
        return com.cskaoyan.mall.util.utiLJW.ReturnUtils.ok(hashMap, "成功");


    }
}
