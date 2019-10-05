package com.cskaoyan.mall.service.adminservice.admin;

import com.cskaoyan.mall.bean.BaseRespVo;

public interface LogService {

    BaseRespVo logListInfo(int page, int limit,String name);
}
