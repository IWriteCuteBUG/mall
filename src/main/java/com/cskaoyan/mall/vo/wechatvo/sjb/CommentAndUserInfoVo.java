package com.cskaoyan.mall.vo.wechatvo.sjb;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CommentAndUserInfoVo {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;
    private String content;
    private String picList;
    private CommentAndUserInfoToolVo userInfo;

    @Override
    public String toString() {
        return "CommentAndUserInfoVo{" +
                "addTime=" + addTime +
                ", content='" + content + '\'' +
                ", picList='" + picList + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicList() {
        return picList;
    }

    public void setPicList(String picList) {
        this.picList = picList;
    }

    public CommentAndUserInfoToolVo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(CommentAndUserInfoToolVo userInfo) {
        this.userInfo = userInfo;
    }

    public CommentAndUserInfoVo(Date addTime, String content, String picList, CommentAndUserInfoToolVo userInfo) {
        this.addTime = addTime;
        this.content = content;
        this.picList = picList;
        this.userInfo = userInfo;
    }

    public CommentAndUserInfoVo() {
    }
}
