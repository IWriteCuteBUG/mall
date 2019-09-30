package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.SearchHistory;
import com.cskaoyan.mall.bean.SearchHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SearchHistoryMapper {
    long countByExample(SearchHistoryExample example);

    int deleteByExample(SearchHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SearchHistory record);

    int insertSelective(SearchHistory record);

    List<SearchHistory> selectByExample(SearchHistoryExample example);

    SearchHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SearchHistory record, @Param("example") SearchHistoryExample example);

    int updateByExample(@Param("record") SearchHistory record, @Param("example") SearchHistoryExample example);

    int updateByPrimaryKeySelective(SearchHistory record);

    int updateByPrimaryKey(SearchHistory record);
}