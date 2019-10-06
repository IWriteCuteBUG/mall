package com.cskaoyan.mall.service.wechatservice.cly.impl;

import com.cskaoyan.mall.bean.Order;
import com.cskaoyan.mall.bean.OrderGoods;
import com.cskaoyan.mall.bean.OrderGoodsExample;
import com.cskaoyan.mall.mapper.OrderGoodsMapper;
import com.cskaoyan.mall.mapper.OrderMapper;
import com.cskaoyan.mall.service.wechatservice.cly.ClyOrderService;
import com.cskaoyan.mall.utils.wechatutils.cly.SetOrderDetailUtil;
import com.cskaoyan.mall.vo.wechatvo.cly.ForOrderDetail;
import com.cskaoyan.mall.vo.wechatvo.cly.WxClyHandleOption;
import com.cskaoyan.mall.vo.wechatvo.cly.WxClyOrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClyOrderServiceImpl implements ClyOrderService {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderGoodsMapper orderGoodsMapper;
    @Override
    public ForOrderDetail queryOrderDetail(int orderId) {
        //orderGoods
        //orderInfo
        ForOrderDetail forOrderDetail = new ForOrderDetail();

        //orderGoods
        OrderGoodsExample orderGoodsExample = new OrderGoodsExample();
        OrderGoodsExample.Criteria criteria = orderGoodsExample.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        List<OrderGoods> orderGoods = orderGoodsMapper.selectByExample(orderGoodsExample);

        //orderInfo
        Order order = orderMapper.selectByPrimaryKey(orderId);
        WxClyOrderInfo orderInfo = forOrderDetail.getOrderInfo();
        WxClyHandleOption handleOption = orderInfo.getHandleOption();

        SetOrderDetailUtil.setOrderInfo(order, orderInfo, handleOption);

        forOrderDetail.setOrderGoods(orderGoods);
        forOrderDetail.setOrderInfo(orderInfo);

        return forOrderDetail;
    }

    @Override
    public void cancelOrder(int orderId) {
        orderMapper.deleteByPrimaryKey(orderId);
        OrderGoodsExample orderGoodsExample = new OrderGoodsExample();
        OrderGoodsExample.Criteria criteria = orderGoodsExample.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        int count = orderGoodsMapper.deleteByExample(orderGoodsExample);
    }
}
