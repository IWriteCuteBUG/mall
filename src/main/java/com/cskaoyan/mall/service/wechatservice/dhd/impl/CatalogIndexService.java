package com.cskaoyan.mall.service.wechatservice.dhd.impl;

import com.cskaoyan.mall.bean.BaseRespVo;

public interface CatalogIndexService {
    BaseRespVo selectCatalogIndex();

    BaseRespVo selectCurrentlogIndex(int id);

}
