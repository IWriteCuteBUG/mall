package com.cskaoyan.mall.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface cskaoyan_mall_topicMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_topic
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    long countByExample(com.cskaoyan.mall.bean.cskaoyan_mall_topicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_topic
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    int deleteByExample(com.cskaoyan.mall.bean.cskaoyan_mall_topicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_topic
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_topic
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    int insert(com.cskaoyan.mall.bean.cskaoyan_mall_topic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_topic
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    int insertSelective(com.cskaoyan.mall.bean.cskaoyan_mall_topic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_topic
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    List<com.cskaoyan.mall.bean.cskaoyan_mall_topic> selectByExampleWithBLOBs(com.cskaoyan.mall.bean.cskaoyan_mall_topicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_topic
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    List<com.cskaoyan.mall.bean.cskaoyan_mall_topic> selectByExample(com.cskaoyan.mall.bean.cskaoyan_mall_topicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_topic
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    com.cskaoyan.mall.bean.cskaoyan_mall_topic selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_topic
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    int updateByExampleSelective(@Param("record") com.cskaoyan.mall.bean.cskaoyan_mall_topic record, @Param("example") com.cskaoyan.mall.bean.cskaoyan_mall_topicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_topic
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    int updateByExampleWithBLOBs(@Param("record") com.cskaoyan.mall.bean.cskaoyan_mall_topic record, @Param("example") com.cskaoyan.mall.bean.cskaoyan_mall_topicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_topic
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    int updateByExample(@Param("record") com.cskaoyan.mall.bean.cskaoyan_mall_topic record, @Param("example") com.cskaoyan.mall.bean.cskaoyan_mall_topicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_topic
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    int updateByPrimaryKeySelective(com.cskaoyan.mall.bean.cskaoyan_mall_topic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_topic
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(com.cskaoyan.mall.bean.cskaoyan_mall_topic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_topic
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    int updateByPrimaryKey(com.cskaoyan.mall.bean.cskaoyan_mall_topic record);
}