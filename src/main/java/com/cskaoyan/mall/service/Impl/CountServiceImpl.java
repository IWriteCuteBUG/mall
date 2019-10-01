package com.cskaoyan.mall.service.Impl;

import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.mapper.*;
import com.cskaoyan.mall.service.CountService;
import com.cskaoyan.mall.vo.tvo.*;
import com.cskaoyan.utils.CountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CountServiceImpl implements CountService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderGoodsMapper orderGoodsMapper;

    @Autowired
    GoodsProductMapper goodsProductMapper;

    @Override
    public CountVo countUserLoginInfo() {
        //先查询出来个用户登录日期
        List<String> loginDateTime =  userMapper.queryDateOfUserLogin();
        List<String> loginDate = CountUtil.DateTimeList2DateList(loginDateTime);
        CountVo<CountVoDayAndUsers> countVo = new CountVo();
        List<CountVoDayAndUsers> countVoDayAndUsersList = new ArrayList<>();
        //查某天登录多少用户
        for (String s : loginDate) {
            int users = userMapper.countUsersOfDay(s);
            CountVoDayAndUsers countVoDayAndUsers = new CountVoDayAndUsers();
            countVoDayAndUsers.setDay(s);
            countVoDayAndUsers.setUsers(users);
            countVoDayAndUsersList.add(countVoDayAndUsers);
        }
        String[] strings = new String[2];
        strings[0] = "day";
        strings[1] = "users";
        countVo.setColumns(strings);
        countVo.setRows(countVoDayAndUsersList);
        return countVo;
    }

    @Override
    public CountVo countOrderInfo() {
        List<String> orderCreateTimeList =  orderMapper.queryDateOfOrderCreate();
        List<String> orderCreateDateList = CountUtil.DateTimeList2DateList(orderCreateTimeList);
        CountVo<CountVoOrderInfo> countVo = new CountVo();
        List<CountVoOrderInfo> countVoOrderInfos = new ArrayList<>();
        //统计订单
        for (String s : orderCreateDateList) {
            int orders = orderMapper.countOrderOrdersByDate(s);
            int customers = orderMapper.countOrderCustomersByDate(s);
            int amount = orderMapper.countOrderAmountByDate(s);
            int pcr = amount / customers;
            CountVoOrderInfo countVoOrderInfo = new CountVoOrderInfo();
            countVoOrderInfo.setAmount(amount);
            countVoOrderInfo.setCustomers(customers);
            countVoOrderInfo.setOrders(orders);
            countVoOrderInfo.setDay(s);
            countVoOrderInfo.setPcr(pcr);
            countVoOrderInfos.add(countVoOrderInfo);
        }
        String[] strings = new String[5];
        strings[0] = "day";
        strings[1] = "orders";
        strings[2] = "customers";
        strings[3] = "amount";
        strings[4] = "pcr";
        countVo.setColumns(strings);
        countVo.setRows(countVoOrderInfos);
        return countVo;
    }

    @Override
    public CountVo countGoodsInfo() {
        List<String> orderCreateTimeList =  orderMapper.queryDateOfOrderCreate();
        List<String> orderCreateDateList = CountUtil.DateTimeList2DateList(orderCreateTimeList);
        CountVo<CountVoGoods> countVo = new CountVo();
        List<CountVoGoods> countVoGoodsList = new ArrayList<>();
        //统计订单
        for (String s : orderCreateDateList) {
            int orders = orderMapper.countOrderOrdersByDate(s);
            int amount = orderMapper.countOrderAmountByDate(s);
            int products = orderGoodsMapper.countGoodsByDate(s);
            CountVoGoods countVoGoods = new CountVoGoods();
            countVoGoods.setOrders(orders);
            countVoGoods.setDay(s);
            countVoGoods.setAmount(amount);
            countVoGoods.setProducts(products);
            countVoGoodsList.add(countVoGoods);
        }
        String[] strings = new String[4];
        strings[0] = "day";
        strings[1] = "orders";
        strings[2] = "products";
        strings[3] = "amount";
        countVo.setColumns(strings);
        countVo.setRows(countVoGoodsList);
        return countVo;
    }

    @Override
    public IndexVoInfo queryInfoIndex() {

        int goods = goodsProductMapper.queryGoodsMumber();
        int products = goodsProductMapper.queryProductMumber();
        int users = userMapper.queryUserTotal();
        int orders = orderMapper.queryOrdersTotal();
        IndexVoInfo indexVoInfo = new IndexVoInfo();
        indexVoInfo.setGoodsTotal(goods);
        indexVoInfo.setOrderTotal(orders);
        indexVoInfo.setProductTotal(products);
        indexVoInfo.setUserTotal(users);
        return indexVoInfo;
    }

}
