package com.cskaoyan.mall.service.wechatservice.zyp.impl;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Groupon;
import com.cskaoyan.mall.mapper.GrouponMapper;
import com.cskaoyan.mall.service.wechatservice.zyp.WechatGrouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeChatGrouponServiceImpl implements WechatGrouponService {
    @Autowired
    GrouponMapper grouponMapper;

    @Override
    public BaseRespVo queryGrouponByShowType(int showType) {
        int userId = 1;
        return null;
    }
}
