package com.cskaoyan.mall.vo.wechatvo.sjb;

import java.util.Arrays;

public class CommentPostReqVo {
    private String content;
    private boolean hasPicture;
    private String[] picUrls;
    private int star;
    private int type;
    private int valueId;

    @Override
    public String toString() {
        return "CommentPostReqVo{" +
                "content='" + content + '\'' +
                ", hasPicture=" + hasPicture +
                ", picUrls=" + Arrays.toString(picUrls) +
                ", star=" + star +
                ", type=" + type +
                ", valueId=" + valueId +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isHasPicture() {
        return hasPicture;
    }

    public void setHasPicture(boolean hasPicture) {
        this.hasPicture = hasPicture;
    }

    public String[] getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(String[] picUrls) {
        this.picUrls = picUrls;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getValueId() {
        return valueId;
    }

    public void setValueId(int valueId) {
        this.valueId = valueId;
    }

    public CommentPostReqVo(String content, boolean hasPicture, String[] picUrls, int star, int type, int valueId) {
        this.content = content;
        this.hasPicture = hasPicture;
        this.picUrls = picUrls;
        this.star = star;
        this.type = type;
        this.valueId = valueId;
    }

    public CommentPostReqVo() {
    }
}
