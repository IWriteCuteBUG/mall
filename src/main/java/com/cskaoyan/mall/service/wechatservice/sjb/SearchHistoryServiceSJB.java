package com.cskaoyan.mall.service.wechatservice.sjb;

import com.cskaoyan.mall.bean.SearchHistory;

import java.util.List;

public interface SearchHistoryServiceSJB {
    List<SearchHistory> querySearchHistoryByUserId(int userId);

    int addSearchHistory(SearchHistory searchHistory);
}
