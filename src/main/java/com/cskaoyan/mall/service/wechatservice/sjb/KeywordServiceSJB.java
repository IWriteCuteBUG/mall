package com.cskaoyan.mall.service.wechatservice.sjb;

import com.cskaoyan.mall.bean.Keyword;

import java.util.List;

public interface KeywordServiceSJB {
    Keyword getDefaultKeyword();

    List<Keyword> getHotKeywordList();

}
