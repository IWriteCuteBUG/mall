package com.cskaoyan.mall.service.wechatservice.sjb.impl;

import com.cskaoyan.mall.bean.SearchHistory;
import com.cskaoyan.mall.bean.SearchHistoryExample;
import com.cskaoyan.mall.mapper.SearchHistoryMapper;
import com.cskaoyan.mall.service.wechatservice.sjb.SearchHistoryServiceSJB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchHistoryServiceSJBImpl implements SearchHistoryServiceSJB {
    @Autowired
    SearchHistoryMapper searchHistoryMapper;

    @Override
    public List<SearchHistory> querySearchHistoryByUserId(int userId) {
        SearchHistoryExample example = new SearchHistoryExample();
        SearchHistoryExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return searchHistoryMapper.selectByExample(example);
    }
}
