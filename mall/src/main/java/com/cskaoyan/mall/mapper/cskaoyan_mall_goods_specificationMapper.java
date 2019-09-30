package main.java.com.cskaoyan.mall.mapper;

import com.cskaoyan.bean.cskaoyan_mall_goods_specification;
import com.cskaoyan.bean.cskaoyan_mall_goods_specificationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface cskaoyan_mall_goods_specificationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_goods_specification
     *
     * @mbg.generated Mon Sep 30 12:00:17 CST 2019
     */
    long countByExample(cskaoyan_mall_goods_specificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_goods_specification
     *
     * @mbg.generated Mon Sep 30 12:00:17 CST 2019
     */
    int deleteByExample(cskaoyan_mall_goods_specificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_goods_specification
     *
     * @mbg.generated Mon Sep 30 12:00:17 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_goods_specification
     *
     * @mbg.generated Mon Sep 30 12:00:17 CST 2019
     */
    int insert(cskaoyan_mall_goods_specification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_goods_specification
     *
     * @mbg.generated Mon Sep 30 12:00:17 CST 2019
     */
    int insertSelective(cskaoyan_mall_goods_specification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_goods_specification
     *
     * @mbg.generated Mon Sep 30 12:00:17 CST 2019
     */
    List<cskaoyan_mall_goods_specification> selectByExample(cskaoyan_mall_goods_specificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_goods_specification
     *
     * @mbg.generated Mon Sep 30 12:00:17 CST 2019
     */
    cskaoyan_mall_goods_specification selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_goods_specification
     *
     * @mbg.generated Mon Sep 30 12:00:17 CST 2019
     */
    int updateByExampleSelective(@Param("record") cskaoyan_mall_goods_specification record, @Param("example") cskaoyan_mall_goods_specificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_goods_specification
     *
     * @mbg.generated Mon Sep 30 12:00:17 CST 2019
     */
    int updateByExample(@Param("record") cskaoyan_mall_goods_specification record, @Param("example") cskaoyan_mall_goods_specificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_goods_specification
     *
     * @mbg.generated Mon Sep 30 12:00:17 CST 2019
     */
    int updateByPrimaryKeySelective(cskaoyan_mall_goods_specification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_goods_specification
     *
     * @mbg.generated Mon Sep 30 12:00:17 CST 2019
     */
    int updateByPrimaryKey(cskaoyan_mall_goods_specification record);
}
