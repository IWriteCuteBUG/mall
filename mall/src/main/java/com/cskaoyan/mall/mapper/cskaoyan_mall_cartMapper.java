package main.java.com.cskaoyan.mall.mapper;

import com.cskaoyan.bean.cskaoyan_mall_cart;
import com.cskaoyan.bean.cskaoyan_mall_cartExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface cskaoyan_mall_cartMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_cart
     *
     * @mbg.generated Mon Sep 30 12:00:17 CST 2019
     */
    long countByExample(cskaoyan_mall_cartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_cart
     *
     * @mbg.generated Mon Sep 30 12:00:17 CST 2019
     */
    int deleteByExample(cskaoyan_mall_cartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_cart
     *
     * @mbg.generated Mon Sep 30 12:00:17 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_cart
     *
     * @mbg.generated Mon Sep 30 12:00:17 CST 2019
     */
    int insert(cskaoyan_mall_cart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_cart
     *
     * @mbg.generated Mon Sep 30 12:00:17 CST 2019
     */
    int insertSelective(cskaoyan_mall_cart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_cart
     *
     * @mbg.generated Mon Sep 30 12:00:17 CST 2019
     */
    List<cskaoyan_mall_cart> selectByExample(cskaoyan_mall_cartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_cart
     *
     * @mbg.generated Mon Sep 30 12:00:17 CST 2019
     */
    cskaoyan_mall_cart selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_cart
     *
     * @mbg.generated Mon Sep 30 12:00:17 CST 2019
     */
    int updateByExampleSelective(@Param("record") cskaoyan_mall_cart record, @Param("example") cskaoyan_mall_cartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_cart
     *
     * @mbg.generated Mon Sep 30 12:00:17 CST 2019
     */
    int updateByExample(@Param("record") cskaoyan_mall_cart record, @Param("example") cskaoyan_mall_cartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_cart
     *
     * @mbg.generated Mon Sep 30 12:00:17 CST 2019
     */
    int updateByPrimaryKeySelective(cskaoyan_mall_cart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cskaoyan_mall_cart
     *
     * @mbg.generated Mon Sep 30 12:00:17 CST 2019
     */
    int updateByPrimaryKey(cskaoyan_mall_cart record);
}
