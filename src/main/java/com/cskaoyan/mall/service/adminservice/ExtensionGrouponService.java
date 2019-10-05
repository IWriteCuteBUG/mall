package com.cskaoyan.mall.service.adminservice;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.GrouponRules;
import com.cskaoyan.mall.vo.adminvo.extensionvo.FromRequestKey;

public interface ExtensionGrouponService {

    BaseRespVo queryGrouponListByGoodsId(FromRequestKey fromRequestKey);

    BaseRespVo queryGrouponCreate(GrouponRules grouponRules);

    BaseRespVo queryGrouponDelete(GrouponRules grouponRules);

    BaseRespVo queryGrouponUpdate(GrouponRules grouponRules);
}
