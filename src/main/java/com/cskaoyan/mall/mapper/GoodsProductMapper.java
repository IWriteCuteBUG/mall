package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.GoodsProduct;
import com.cskaoyan.mall.bean.GoodsProductExample;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface GoodsProductMapper {
    long countByExample(GoodsProductExample example);

    int deleteByExample(GoodsProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsProduct record);

    int insertSelective(GoodsProduct record);

    List<GoodsProduct> selectByExample(GoodsProductExample example);

    GoodsProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsProduct record, @Param("example") GoodsProductExample example);

    int updateByExample(@Param("record") GoodsProduct record, @Param("example") GoodsProductExample example);

    int updateByPrimaryKeySelective(GoodsProduct record);

    int updateByPrimaryKey(GoodsProduct record);

    int queryGoodsMumber();

    int queryProductMumber();

    List<GoodsProduct> queryGoodsProductById(@Param("id") int id);


    void updateNumber(@Param("id") Integer productId,@Param("number") Short number);

    int queryProductMumberCly(@Param("id") Integer productId);


    @Select("select price from  cskaoyan_mall_goods_product where id=#{productId}")
    BigDecimal selectPriceById(Integer productId);
//
//    @Update("update cskaoyan_mall_goods_product set number=number-#{number} where id=#{productId}")
//    void updateNumber(Short number, Integer productId);


    @Select("select specifications from cskaoyan_mall_goods_product where id=#{productId}")
    String selectSpec(Integer productId);
//
//    @Update("update cskaoyan_mall_goods_product set number=number-#{number} where id=#{productId}")
//    void updateNumber(Short number, Integer productId);



}
