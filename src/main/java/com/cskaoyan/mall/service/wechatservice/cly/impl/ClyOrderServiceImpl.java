package com.cskaoyan.mall.service.wechatservice.cly.impl;

import com.cskaoyan.mall.bean.Order;
import com.cskaoyan.mall.bean.OrderGoods;
import com.cskaoyan.mall.bean.OrderGoodsExample;
import com.cskaoyan.mall.mapper.GoodsProductMapper;
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

    @Autowired
    GoodsProductMapper goodsProductMapper;
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
        //WxClyOrderInfo orderInfo = forOrderDetail.getOrderInfo();
        //WxClyHandleOption handleOption = orderInfo.getHandleOption();
        WxClyOrderInfo orderInfo = new WxClyOrderInfo();
        WxClyHandleOption handleOption = new WxClyHandleOption();

        SetOrderDetailUtil.setOrderInfo(order, orderInfo, handleOption);

        orderInfo.setHandleOption(handleOption);

        forOrderDetail.setOrderGoods(orderGoods);
        forOrderDetail.setOrderInfo(orderInfo);

        return forOrderDetail;
    }

    @Override
    public void cancelOrder(int orderId) {
        String s = String.valueOf(orderId);
        orderMapper.updateOrderStatusCly(s);
        OrderGoodsExample orderGoodsExample = new OrderGoodsExample();
        OrderGoodsExample.Criteria criteria = orderGoodsExample.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        //获取订单中商品的信息，为修改库存做准备
        List<OrderGoods> orderGoods = orderGoodsMapper.selectByExample(orderGoodsExample);
        int count = orderGoodsMapper.deleteByExample(orderGoodsExample);
        //修改商品库存
        for (OrderGoods orderGood : orderGoods) {
            Integer productId = orderGood.getProductId();
            int number = goodsProductMapper.queryProductMumberCly(productId);
            Short numberOrder = orderGood.getNumber();
            number += numberOrder;
            goodsProductMapper.updateNumber(productId, (short)number);
        }
    }
}
