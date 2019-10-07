package com.cskaoyan.mall.service.wechatservice.zyp;

import com.cskaoyan.mall.bean.BaseRespVo;

public interface WechatGrouponService {
    BaseRespVo queryGrouponByShowType(int showType);

    BaseRespVo queryGrouponDetailByShowType(Integer grouponOnId);

    BaseRespVo queryGrouponlist(Integer page, Integer size);
}
