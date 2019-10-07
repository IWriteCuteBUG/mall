package com.cskaoyan.mall.vo.wechatvo.sjb;

public class StringToolVo {
    private String keyword;

    public StringToolVo(String keyword) {
        this.keyword = keyword;
    }

    public StringToolVo() {
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return "StringToolVo{" +
                "keyword='" + keyword + '\'' +
                '}';
    }
}
