package com.cskaoyan.mall.service.wechatservice.zyp.impl;

import com.cskaoyan.mall.bean.Order;
import com.cskaoyan.mall.bean.OrderExample;
import com.cskaoyan.mall.bean.UserExample;
import com.cskaoyan.mall.mapper.OrderMapper;
import com.cskaoyan.mall.mapper.UserFormidMapper;
import com.cskaoyan.mall.mapper.UserMapper;
import com.cskaoyan.mall.service.wechatservice.zyp.WxAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WxAuthServiceImpl implements WxAuthService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    OrderMapper orderMapper;

    @Override
    public Integer queryIdByUsername(String username) {
        String idString = userMapper.queryIdByUsername(username);
        Integer id = Integer.valueOf(idString);
        return id;
    }

    @Override
    public List<Order> queryOrdersByUserIdAndOrderStatus(Integer userId, Integer status) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria().andUserIdEqualTo(userId);
        ArrayList<Short> statusList = new ArrayList<>();
        if (status == 0) {
            criteria.andOrderStatusEqualTo((short) 101);
        }
        if (status == 1) {
            criteria.andOrderStatusEqualTo((short) 201);
        }
        if (status == 2) {
            criteria.andOrderStatusEqualTo((short) 301);
        }
        if (status == 3) {
            statusList.add((short) 402);
            statusList.add((short) 401);
            criteria.andOrderStatusIn(statusList);
        }
        List<Order> orderList = orderMapper.selectByExample(orderExample);
        return orderList;
    }


}
