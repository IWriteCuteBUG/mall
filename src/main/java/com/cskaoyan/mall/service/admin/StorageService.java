package com.cskaoyan.mall.service.admin;

import com.cskaoyan.mall.bean.BaseRespVo;

public interface StorageService {
    BaseRespVo storageInfo(int page, int limit, String key, String name);
}
