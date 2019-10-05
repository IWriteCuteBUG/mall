package com.cskaoyan.mall.service.adminservice;

import com.cskaoyan.mall.vo.adminvo.tvo.ConfigerVo;
import com.cskaoyan.mall.vo.adminvo.tvo.ConfigerVoExpress;
import com.cskaoyan.mall.vo.adminvo.tvo.ConfigerVoOrder;
import com.cskaoyan.mall.vo.adminvo.tvo.ConfigerVoWx;

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
