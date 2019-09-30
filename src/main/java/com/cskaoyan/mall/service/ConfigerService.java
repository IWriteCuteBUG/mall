package com.cskaoyan.mall.service;

import com.cskaoyan.mall.vo.tvo.ConfigerVo;
import com.cskaoyan.mall.vo.tvo.ConfigerVoExpress;
import com.cskaoyan.mall.vo.tvo.ConfigerVoOrder;
import com.cskaoyan.mall.vo.tvo.ConfigerVoWx;

public interface ConfigerService {

    ConfigerVo queryMallConfig();

    boolean updateMallConfig(ConfigerVo configerVo);

    ConfigerVoExpress queryConfigExpress();

    boolean updateMallConfigExpress(ConfigerVoExpress configerVoExpress);

    ConfigerVoOrder queryMallConfigOrder();

    boolean updateMallConfigOrder(ConfigerVoOrder configerVoOrder);

    ConfigerVoWx queryMallConfigWx();

    boolean updateMallConfigWx(ConfigerVoWx configerVoWx);
}
