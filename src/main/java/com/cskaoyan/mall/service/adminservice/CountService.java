package com.cskaoyan.mall.service.adminservice;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.vo.adminvo.tvo.CountVo;
import com.cskaoyan.mall.vo.adminvo.tvo.IndexVoInfo;

public interface CountService {
    CountVo countUserLoginInfo();

    CountVo countOrderInfo();

    CountVo countGoodsInfo();

    IndexVoInfo queryInfoIndex();

    BaseRespVo countGoodsNumber();
}
