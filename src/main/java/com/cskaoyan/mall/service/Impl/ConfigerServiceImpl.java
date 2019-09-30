package com.cskaoyan.mall.service.Impl;

import com.cskaoyan.mall.mapper.SystemMapper;
import com.cskaoyan.mall.service.ConfigerService;
import com.cskaoyan.mall.vo.tvo.ConfigerVo;
import com.cskaoyan.mall.vo.tvo.ConfigerVoExpress;
import com.cskaoyan.mall.vo.tvo.ConfigerVoOrder;
import com.cskaoyan.mall.vo.tvo.ConfigerVoWx;
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
        configerVo.setCskaoyan_mall_mall_name(name);
        configerVo.setCskaoyan_mall_mall_qq(qq);
        configerVo.setCskaoyan_mall_mall_phone(phone);
        configerVo.setCskaoyan_mall_mall_address(adress);
        return configerVo;
    }

    @Override
    public boolean updateMallConfig(ConfigerVo configerVo) {
        systemMapper.updateMallConfigOfQQ(configerVo.getCskaoyan_mall_mall_qq());
        systemMapper.updateMallConfigOfName(configerVo.getCskaoyan_mall_mall_name());
        systemMapper.updateMallConfigOfPhone(configerVo.getCskaoyan_mall_mall_phone());
        systemMapper.updateMallConfigOfAdress(configerVo.getCskaoyan_mall_mall_address());
        return true;
    }

    @Override
    public ConfigerVoExpress queryConfigExpress() {
        String min = systemMapper.queryLitemall_express_freight_min(5);
        String value = systemMapper.queryLitemall_express_freight_value(7);
        ConfigerVoExpress configerVoExpress = new ConfigerVoExpress();
        configerVoExpress.setCskaoyan_mall_express_freight_min(min);
        configerVoExpress.setCskaoyan_mall_express_freight_value(value);
        return configerVoExpress;
    }

    @Override
    public boolean updateMallConfigExpress(ConfigerVoExpress configerVoExpress) {
        systemMapper.updateMallConfigExpressForMin(configerVoExpress.getCskaoyan_mall_express_freight_min());
        systemMapper.updateMallConfigExpressForValue(configerVoExpress.getCskaoyan_mall_express_freight_value());
        return true;
    }

    @Override
    public ConfigerVoOrder queryMallConfigOrder() {
        String comment = systemMapper.queryMallConfigOfCommentById(10);
        String unpaid = systemMapper.queryMallConfigOfUnpaidById(1);
        String unconfirm = systemMapper.queryMallConfigOfUnconfirmById(3);
        ConfigerVoOrder configerVoOrder = new ConfigerVoOrder();
        configerVoOrder.setCskaoyan_mall_order_comment(comment);
        configerVoOrder.setCskaoyan_mall_order_unconfirm(unconfirm);
        configerVoOrder.setCskaoyan_mall_order_unpaid(unpaid);
        return configerVoOrder;
    }

    @Override
    public boolean updateMallConfigOrder(ConfigerVoOrder configerVoOrder) {
        systemMapper.updateMallConfigOrderOfComment(configerVoOrder.getCskaoyan_mall_order_comment());
        systemMapper.updateMallConfigOrderOfUnconfirm(configerVoOrder.getCskaoyan_mall_order_unconfirm());
        systemMapper.updateMallConfigOrderOfUnpaid(configerVoOrder.getCskaoyan_mall_order_unpaid());
        return true;
    }

    @Override
    public ConfigerVoWx queryMallConfigWx() {
        String news =systemMapper.queryMallConfigWxOfNew(2);
        String share =systemMapper.queryMallConfigWxOfShare(4);
        String hot =systemMapper.queryMallConfigWxOfHot(9);
        String goods =systemMapper.queryMallConfigWxOfGoods(11);
        String list =systemMapper.queryMallConfigWxOfList(13);
        String brand =systemMapper.queryMallConfigWxOfBrand(15);
        String topic =systemMapper.queryMallConfigWxOfTopic(16);
        ConfigerVoWx configerVoWx = new ConfigerVoWx();
        configerVoWx.setCskaoyan_mall_wx_catlog_goods(goods);
        configerVoWx.setCskaoyan_mall_wx_catlog_list(list);
        configerVoWx.setCskaoyan_mall_wx_index_brand(brand);
        configerVoWx.setCskaoyan_mall_wx_index_hot(hot);
        configerVoWx.setCskaoyan_mall_wx_index_new(news);
        configerVoWx.setCskaoyan_mall_wx_index_topic(topic);
        configerVoWx.setCskaoyan_mall_wx_share(share);
        return configerVoWx;
    }

    @Override
    public boolean updateMallConfigWx(ConfigerVoWx configerVoWx) {
        systemMapper.updateMallConfigWxOfGoods(configerVoWx.getCskaoyan_mall_wx_catlog_goods());
        systemMapper.updateMallConfigWxOfList(configerVoWx.getCskaoyan_mall_wx_catlog_list());
        systemMapper.updateMallConfigWxOfBrand(configerVoWx.getCskaoyan_mall_wx_index_brand());
        systemMapper.updateMallConfigWxOfHot(configerVoWx.getCskaoyan_mall_wx_index_hot());
        systemMapper.updateMallConfigWxOfNew(configerVoWx.getCskaoyan_mall_wx_index_new());
        systemMapper.updateMallConfigWxOfTopic(configerVoWx.getCskaoyan_mall_wx_index_topic());
        systemMapper.updateMallConfigWxOfShare(configerVoWx.getCskaoyan_mall_wx_share());
        return true;
    }


}
