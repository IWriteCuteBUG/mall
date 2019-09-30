package com.cskaoyan.mall.service.Impl;

import com.cskaoyan.mall.mapper.SystemMapper;
import com.cskaoyan.mall.service.ConfigerService;
import com.cskaoyan.mall.vo.tvo.ConfigerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigerServiceImpl implements ConfigerService {

    @Autowired
    SystemMapper systemMapper;

    /**
     * 查询商城信息
     * @return
     */
    @Override
    public ConfigerVo queryMallConfig() {
        int i = 6;
        String name = systemMapper.queryMallConfigOfNameById(i);
        String qq = systemMapper.queryMallConfigOfQQById(8);
        String adress = systemMapper.queryMallConfigOfAdressById(14);
        String phone = systemMapper.queryMallConfigOfPhoneById(12);
        ConfigerVo configerVo = new ConfigerVo();
        configerVo.setLitemall_mall_name(name);
        configerVo.setLitemall_mall_qq(qq);
        configerVo.setLitemall_mall_phone(phone);
        configerVo.setLitemall_mall_address(adress);
        return configerVo;
    }

    @Override
    public boolean updateMallConfig(ConfigerVo configerVo) {
        systemMapper.updateMallConfigOfQQ(configerVo.getLitemall_mall_qq());
        systemMapper.updateMallConfigOfName(configerVo.getLitemall_mall_name());
        systemMapper.updateMallConfigOfPhone(configerVo.getLitemall_mall_phone());
        systemMapper.updateMallConfigOfAdress(configerVo.getLitemall_mall_address());
        return true;
    }
}
