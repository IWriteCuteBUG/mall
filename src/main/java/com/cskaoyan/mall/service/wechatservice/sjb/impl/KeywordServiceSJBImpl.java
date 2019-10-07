package com.cskaoyan.mall.service.wechatservice.sjb.impl;

import com.cskaoyan.mall.bean.Keyword;
import com.cskaoyan.mall.bean.KeywordExample;
import com.cskaoyan.mall.mapper.KeywordMapper;
import com.cskaoyan.mall.service.wechatservice.sjb.KeywordServiceSJB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordServiceSJBImpl implements KeywordServiceSJB {

    @Autowired
    KeywordMapper keywordMapper;

    @Override
    public Keyword getDefaultKeyword() {
        return keywordMapper.queryDefaultKeyword();
    }

    @Override
    public List<Keyword> getHotKeywordList() {
        return keywordMapper.queryHotKeywordList();
    }
}
