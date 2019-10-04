package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.vo.tvo.CountVo;
import com.cskaoyan.mall.vo.tvo.IndexVoInfo;

public interface CountService {
    CountVo countUserLoginInfo();

    CountVo countOrderInfo();

    CountVo countGoodsInfo();

    IndexVoInfo queryInfoIndex();

    BaseRespVo countGoodsNumber();
}
