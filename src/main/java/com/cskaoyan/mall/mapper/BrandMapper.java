package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Brand;
import com.cskaoyan.mall.bean.BrandExample;
import java.util.List;


import com.cskaoyan.mall.vo.adminvo.goodsmanagervo.ForBrandList;
import com.cskaoyan.mall.vo.adminvo.voLJW.BrandModify;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface BrandMapper {
    @Select("select `desc`,floor_price,name,pic_url,upDate_Time where id=#{id}  ")
    BrandModify selectBrandForUpdate(@Param("id") int id);

    @Delete("delete from brand where id=#{id}")
    int  deleteBrand(@Param("id") int id);


    long countByExample(BrandExample example);

    int deleteByExample(BrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Brand record);

    int insertSelective(Brand record);

    List<Brand> selectByExample(BrandExample example);

    Brand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByExample(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);
    List<ForBrandList> queryBrandList();

    Brand queryBrandByGoodsId(@Param("id") int id);
}
