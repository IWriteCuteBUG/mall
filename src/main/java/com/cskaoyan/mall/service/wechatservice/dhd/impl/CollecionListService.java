package com.cskaoyan.mall.service.wechatservice.dhd.impl;

import com.cskaoyan.mall.bean.BaseRespVo;

public interface CollecionListService {
    BaseRespVo colleciontList(int userid, int type, int page, int size);
}
