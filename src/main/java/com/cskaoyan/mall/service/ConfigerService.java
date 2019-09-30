package com.cskaoyan.mall.service;

import com.cskaoyan.mall.vo.tvo.ConfigerVo;

public interface ConfigerService {

    ConfigerVo queryMallConfig();

    boolean updateMallConfig(ConfigerVo configerVo);
}
