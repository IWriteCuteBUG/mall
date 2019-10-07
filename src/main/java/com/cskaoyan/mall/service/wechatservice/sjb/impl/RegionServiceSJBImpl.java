package com.cskaoyan.mall.service.wechatservice.sjb.impl;

import com.cskaoyan.mall.mapper.RegionMapper;
import com.cskaoyan.mall.service.wechatservice.sjb.RegionServiceSJB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceSJBImpl implements RegionServiceSJB {
    @Autowired
    RegionMapper regionMapper;

    @Override
    public String queryNameById(int id) {
        return regionMapper.selectByPrimaryKey(id).getName();
    }
}
