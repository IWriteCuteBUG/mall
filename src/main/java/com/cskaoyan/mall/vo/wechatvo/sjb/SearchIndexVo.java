package com.cskaoyan.mall.vo.wechatvo.sjb;

import com.cskaoyan.mall.bean.Keyword;

import java.util.List;

public class SearchIndexVo<T> {
    private Keyword defaultKeyword;
    private List<T> historyKeywordList;
    private List<Keyword> hotKeywordList;

    @Override
    public String toString() {
        return "SearchIndexVo{" +
                "defaultKeyword=" + defaultKeyword +
                ", historyKeywordList=" + historyKeywordList +
                ", hotKeywordList=" + hotKeywordList +
                '}';
    }

    public Keyword getDefaultKeyword() {
        return defaultKeyword;
    }

    public void setDefaultKeyword(Keyword defaultKeyword) {
        this.defaultKeyword = defaultKeyword;
    }

    public List<T> getHistoryKeywordList() {
        return historyKeywordList;
    }

    public void setHistoryKeywordList(List<T> historyKeywordList) {
        this.historyKeywordList = historyKeywordList;
    }

    public List<Keyword> getHotKeywordList() {
        return hotKeywordList;
    }

    public void setHotKeywordList(List<Keyword> hotKeywordList) {
        this.hotKeywordList = hotKeywordList;
    }

    public SearchIndexVo(Keyword defaultKeyword, List<T> historyKeywordList, List<Keyword> hotKeywordList) {
        this.defaultKeyword = defaultKeyword;
        this.historyKeywordList = historyKeywordList;
        this.hotKeywordList = hotKeywordList;
    }

    public SearchIndexVo() {
    }
}
