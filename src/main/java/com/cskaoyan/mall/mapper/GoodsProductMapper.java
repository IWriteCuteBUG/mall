package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.GoodsProduct;
import com.cskaoyan.mall.bean.GoodsProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
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

    @Update("update cskaoyan_mall_goods_product set deleted=#{flag} where goods_id=#{goodsId}")
    void deleteByLogic(@Param("goodsId") Integer id, @Param("flag") boolean deleted);
}
