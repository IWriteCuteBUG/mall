package com.cskaoyan.mall.vo.wechatvo.sjb;

import java.util.Arrays;

public class FeedbackSubmitReqVo {
    private String content;
    private String feedType;
    private boolean hasPicture;
    private String mobile;
    private String[] picUrls;

    @Override
    public String toString() {
        return "FeedbackSubmitReqVo{" +
                "content='" + content + '\'' +
                ", feedType='" + feedType + '\'' +
                ", hasPicture=" + hasPicture +
                ", mobile='" + mobile + '\'' +
                ", picUrls=" + Arrays.toString(picUrls) +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFeedType() {
        return feedType;
    }

    public void setFeedType(String feedType) {
        this.feedType = feedType;
    }

    public boolean isHasPicture() {
        return hasPicture;
    }

    public void setHasPicture(boolean hasPicture) {
        this.hasPicture = hasPicture;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String[] getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(String[] picUrls) {
        this.picUrls = picUrls;
    }

    public FeedbackSubmitReqVo() {
    }

    public FeedbackSubmitReqVo(String content, String feedType, boolean hasPicture, String mobile, String[] picUrls) {
        this.content = content;
        this.feedType = feedType;
        this.hasPicture = hasPicture;
        this.mobile = mobile;
        this.picUrls = picUrls;
    }
}
