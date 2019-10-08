package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Footprint;
import com.cskaoyan.mall.bean.FootprintExample;
import java.util.List;

import com.cskaoyan.mall.vo.wechatvo.sjb.FootprintListToolVo;
import org.apache.ibatis.annotations.Param;

public interface FootprintMapper {
    long countByExample(FootprintExample example);

    int deleteByExample(FootprintExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Footprint record);

    int insertSelective(Footprint record);

    List<Footprint> selectByExample(FootprintExample example);

    Footprint selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Footprint record, @Param("example") FootprintExample example);

    int updateByExample(@Param("record") Footprint record, @Param("example") FootprintExample example);

    int updateByPrimaryKeySelective(Footprint record);

    int updateByPrimaryKey(Footprint record);


    List<FootprintListToolVo> queryFootprintAndGoodsMultiById(@Param("userId") int userId);

    int addFootprintWithoutId(@Param("footprint") Footprint footprint);
}
