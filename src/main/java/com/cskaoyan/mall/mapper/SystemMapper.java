package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.System;
import com.cskaoyan.mall.bean.SystemExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemMapper {
    long countByExample(SystemExample example);

    int deleteByExample(SystemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(System record);

    int insertSelective(System record);

    List<System> selectByExample(SystemExample example);

    System selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") System record, @Param("example") SystemExample example);

    int updateByExample(@Param("record") System record, @Param("example") SystemExample example);

    int updateByPrimaryKeySelective(System record);

    int updateByPrimaryKey(System record);

    String queryMallConfigOfNameById(@Param("id") int id);

    String queryMallConfigOfQQById(@Param("id") int id);

    String queryMallConfigOfAdressById(@Param("id") int id);

    String queryMallConfigOfPhoneById(@Param("id") int id);

    void updateMallConfigOfQQ(@Param("qq") String litemall_mall_qq);

    void updateMallConfigOfName(@Param("name") String litemall_mall_name);

    void updateMallConfigOfPhone(@Param("phone") String litemall_mall_phone);

    void updateMallConfigOfAdress(@Param("adress") String litemall_mall_address);

    String queryLitemall_express_freight_min(@Param("id") int id);

    String queryLitemall_express_freight_value(@Param("id") int id);

    void updateMallConfigExpressForMin(@Param("min") String cskaoyan_mall_express_freight_min);

    void updateMallConfigExpressForValue(@Param("value") String cskaoyan_mall_express_freight_value);

    String queryMallConfigOfCommentById(@Param("id") int id);

    String queryMallConfigOfUnpaidById(@Param("id") int id);

    String queryMallConfigOfUnconfirmById(int i);

    void updateMallConfigOrderOfComment(@Param("comment") String cskaoyan_mall_order_comment);

    void updateMallConfigOrderOfUnconfirm(@Param("unconfirm") String cskaoyan_mall_order_unconfirm);

    void updateMallConfigOrderOfUnpaid(@Param("unipaid") String cskaoyan_mall_order_unpaid);

    String queryMallConfigWxOfNew(@Param("id") int id);

    String queryMallConfigWxOfShare(@Param("id") int id);

    String queryMallConfigWxOfHot(@Param("id") int id);

    String queryMallConfigWxOfGoods(@Param("id") int id);

    String queryMallConfigWxOfList(@Param("id") int id);

    String queryMallConfigWxOfBrand(@Param("id") int id);

    String queryMallConfigWxOfTopic(@Param("id") int id);

    void updateMallConfigWxOfGoods(@Param("goods") String cskaoyan_mall_wx_catlog_goods);

    void updateMallConfigWxOfList(@Param("list") String cskaoyan_mall_wx_catlog_list);

    void updateMallConfigWxOfBrand(@Param("brand") String cskaoyan_mall_wx_index_brand);

    void updateMallConfigWxOfHot(@Param("hot") String cskaoyan_mall_wx_index_hot);

    void updateMallConfigWxOfNew(@Param("new") String cskaoyan_mall_wx_index_new);

    void updateMallConfigWxOfTopic(@Param("topic") String cskaoyan_mall_wx_index_topic);

    void updateMallConfigWxOfShare(@Param("share") String cskaoyan_mall_wx_share);
}
