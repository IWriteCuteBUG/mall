package com.cskaoyan.mall.service.wechatservice.sjb.impl;

import com.cskaoyan.mall.bean.User;
import com.cskaoyan.mall.mapper.UserMapper;
import com.cskaoyan.mall.service.wechatservice.sjb.UserServiceSJB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceSJBImpl implements UserServiceSJB {
    @Autowired
    UserMapper userMapper;

    @Override
    public String getUsernameByUserId(int userId) {

        return userMapper.selectByPrimaryKey(userId).getUsername();
    }

    @Override
    public User getUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
