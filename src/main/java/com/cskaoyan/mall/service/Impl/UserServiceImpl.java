package com.cskaoyan.mall.service.Impl;

import com.cskaoyan.mall.bean.User;
import com.cskaoyan.mall.bean.UserExample;
import com.cskaoyan.mall.mapper.UserMapper;
import com.cskaoyan.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> queryAllUsers() {
        List<User> userList = userMapper.selectByExample(new UserExample());
        return userList;
    }
}
