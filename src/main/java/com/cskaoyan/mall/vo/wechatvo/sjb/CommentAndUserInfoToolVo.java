package com.cskaoyan.mall.vo.wechatvo.sjb;

public class CommentAndUserInfoToolVo {
    private String avatarUrl;
    private String nickName;

    @Override
    public String toString() {
        return "CommentAndUserInfoToolVo{" +
                "avatarUrl='" + avatarUrl + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public CommentAndUserInfoToolVo(String avatarUrl, String nickName) {
        this.avatarUrl = avatarUrl;
        this.nickName = nickName;
    }

    public CommentAndUserInfoToolVo() {
    }
}
