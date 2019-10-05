package com.cskaoyan.mall.vo.adminvo.voSJB;

import com.cskaoyan.mall.bean.SearchHistory;

import java.util.List;

public class SearchHistoryListAndTotalVo {
    private List<SearchHistory> searchHistoryList;
    private int total;

    public SearchHistoryListAndTotalVo() {
    }

    public SearchHistoryListAndTotalVo(List<SearchHistory> searchHistoryList, int total) {
        this.searchHistoryList = searchHistoryList;
        this.total = total;
    }

    public List<SearchHistory> getSearchHistoryList() {
        return searchHistoryList;
    }

    public void setSearchHistoryList(List<SearchHistory> searchHistoryList) {
        this.searchHistoryList = searchHistoryList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "SearchHistoryListAndTotalVo{" +
                "searchHistoryList=" + searchHistoryList +
                ", total=" + total +
                '}';
    }


}
