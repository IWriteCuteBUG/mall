package com.cskaoyan.mall.service.wechatservice.tangsong.impl;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.*;
import com.cskaoyan.mall.service.wechatservice.tangsong.WeChatOrdersService;
import com.cskaoyan.mall.utils.wechatutils.tangsong.OptionUtils;
import com.cskaoyan.mall.vo.wechatvo.tongsong.OrderVo;
import com.cskaoyan.mall.vo.wechatvo.tongsong.OrderVoForReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class WeChatOrdersServiceImpl implements WeChatOrdersService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    AddressMapper addressMapper;

    @Autowired
    CouponMapper couponMapper;

    @Autowired
    GrouponRulesMapper grouponRulesMapper;

    @Autowired
    CartMapper cartMapper;

    @Autowired
    GoodsProductMapper goodsProductMapper;

    @Override
    public BaseRespVo queryOrdersList(int showType,int page,int size) {
        List<OrderVo> orderVoList = null;
        if (showType == 0) {
            //根据订单状态查询出来所有的订单，然后再根据订单编号查询所有的
            orderVoList = orderMapper.queryOrdersList();
        }else if (showType == 1) {
            orderVoList = orderMapper.queryOrdersList1();
        }else if (showType == 2) {
            orderVoList = orderMapper.queryOrdersList2();
        }else if (showType == 3) {
            orderVoList = orderMapper.queryOrdersList3();
        }else if (showType == 4) {
            orderVoList = orderMapper.queryOrdersList4();
        }
        if (orderVoList.size() == 0) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("data",new ArrayList<>());
            map.put("count",0);
            map.put("totalPages",0);
            return BaseRespVo.ok(map);
        }
        for (OrderVo orderVo : orderVoList) {
            int status = orderVo.getStatus();
            OptionUtils optionUtils = new OptionUtils(status);
            orderVo.setHandleOption(optionUtils);
            if (status == 301) {
                orderVo.setOrderStatusText("已发货");
            }else if (status == 203) {
                orderVo.setOrderStatusText("已退款");
            }else if (status == 402) {
                orderVo.setOrderStatusText("已退款");
            }else if (status == 102) {
                orderVo.setOrderStatusText("已取消(用户)");
            }else if (status == 101) {
                orderVo.setOrderStatusText("未付款");
            }else if (status == 202) {
                orderVo.setOrderStatusText("申请退款");
            }else if (status == 401) {
                orderVo.setOrderStatusText("收货(用户)");
            }else if (status == 103) {
                orderVo.setOrderStatusText("系统取消");
            }else if (status == 201) {
                orderVo.setOrderStatusText("已付款");
            }

        }
        OrderVoForReturn data = new OrderVoForReturn();
        data.setData(orderVoList);
        data.setCount(orderVoList.size());
        data.setTotalPages(orderVoList.size()/size);
        /*HashMap<String, Object> map = new HashMap<>();
        map.put("data",orderVoForReturn);*/
        return BaseRespVo.ok(data);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    @Override
    public BaseRespVo submitOrder(SubmitOrders submitOrders) {
        //先取得地址
        int addressId = submitOrders.getAddressId();
        AddressExample addressExample = new AddressExample();
        addressExample.createCriteria().andAreaIdEqualTo(submitOrders.getAddressId());
        List<Address> addresses = addressMapper.selectByExample(addressExample);
        String address = addresses.get(0).getAddress();
        //获取优惠券减免
        CouponExample couponExample = new CouponExample();
        couponExample.createCriteria().andIdEqualTo(submitOrders.getCouponId());
        List<Coupon> coupons = couponMapper.selectByExample(couponExample);
        BigDecimal discount = coupons.get(0).getDiscount();
        //获取团购减免
        GrouponRulesExample grouponRulesExample = new GrouponRulesExample();
        grouponRulesExample.createCriteria().andGoodsIdEqualTo(submitOrders.getGrouponRulesI());
        List<GrouponRules> grouponRules = grouponRulesMapper.selectByExample(grouponRulesExample);
        BigDecimal grouponDescount = grouponRules.get(0).getDiscount();
        //从购物车取到商品数量
        CartExample cartExample = new CartExample();
        cartExample.createCriteria().andGoodsIdEqualTo(submitOrders.getCartId());
        List<Cart> carts = cartMapper.selectByExample(cartExample);
        Cart cart = carts.get(0);
        int number = cart.getNumber();
        String specifications = cart.getSpecifications();
        Integer goodsId = cart.getGoodsId();
        //减去库存
        GoodsProduct goodsProduct = new GoodsProduct();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String addTime = format1.format(new Date());
        Date parse =null;
        try {
            parse = format1.parse(addTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        goodsProduct.setAddTime(parse);
        goodsProduct.setDeleted(false);
        goodsProduct.setNumber(number);
        goodsProduct.setUpdateTime(parse);
        GoodsProductExample goodsProductExample = new GoodsProductExample();
        goodsProductExample.createCriteria().andGoodsIdEqualTo(goodsId).andSpecificationsEqualTo(specifications);
        goodsProductMapper.updateByExample(goodsProduct, goodsProductExample);
        //提交订单
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String orderId = format.format(date);
        Order order = new Order();
        order.setOrderSn(orderId);
        order.setAddress(address);
        order.setAddTime(parse);
        order.setUpdateTime(parse);
        order.setMessage(submitOrders.getMessage());
        order.setGrouponPrice(grouponDescount);
        order.setCouponPrice(discount);
        order.setOrderStatus((short) 101);
        BigDecimal price = cart.getPrice();
        BigDecimal actualPrice = price.subtract(discount).subtract(grouponDescount);
        order.setActualPrice(actualPrice);
        orderMapper.insert(order);
        //插入GoodsAndORDER表
        //查询商品信息
        GoodsProduct goodsProduct1 = new GoodsProduct();
        int number1 = cart.getNumber();
        goodsProduct1.setNumber(number1);
        goodsProduct1.setUpdateTime(parse);
        goodsProduct1.setAddTime(parse);
        goodsProduct1.setPrice(actualPrice);
        goodsProduct1.setUrl(cart.getPicUrl());
        String[] strings = new String[]{specifications};
        goodsProduct1.setSpecifications(strings);
        goodsProduct1.setDeleted(false);
        goodsProductMapper.insert(goodsProduct1);
        //删除购物车
        cartMapper.deleteByPrimaryKey(submitOrders.getCartId());
        return BaseRespVo.ok(orderId);
    }
}
