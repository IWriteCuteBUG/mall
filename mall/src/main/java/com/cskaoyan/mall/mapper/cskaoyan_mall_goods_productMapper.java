package com.cskaoyan.mall.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface cskaoyan_mall_goods_productMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_goods_product
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    long countByExample(main.java.com.cskaoyan.mall.bean.cskaoyan_mall_goods_productExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_goods_product
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    int deleteByExample(main.java.com.cskaoyan.mall.bean.cskaoyan_mall_goods_productExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_goods_product
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_goods_product
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    int insert(main.java.com.cskaoyan.mall.bean.cskaoyan_mall_goods_product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_goods_product
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    int insertSelective(main.java.com.cskaoyan.mall.bean.cskaoyan_mall_goods_product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_goods_product
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    List<main.java.com.cskaoyan.mall.bean.cskaoyan_mall_goods_product> selectByExample(main.java.com.cskaoyan.mall.bean.cskaoyan_mall_goods_productExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_goods_product
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    main.java.com.cskaoyan.mall.bean.cskaoyan_mall_goods_product selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_goods_product
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    int updateByExampleSelective(@Param("record") main.java.com.cskaoyan.mall.bean.cskaoyan_mall_goods_product record, @Param("example") main.java.com.cskaoyan.mall.bean.cskaoyan_mall_goods_productExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_goods_product
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    int updateByExample(@Param("record") main.java.com.cskaoyan.mall.bean.cskaoyan_mall_goods_product record, @Param("example") main.java.com.cskaoyan.mall.bean.cskaoyan_mall_goods_productExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_goods_product
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    int updateByPrimaryKeySelective(main.java.com.cskaoyan.mall.bean.cskaoyan_mall_goods_product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_goods_product
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    int updateByPrimaryKey(main.java.com.cskaoyan.mall.bean.cskaoyan_mall_goods_product record);
}
