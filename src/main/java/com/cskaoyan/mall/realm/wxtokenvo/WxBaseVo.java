package com.cskaoyan.mall.realm.wxtokenvo;

import java.io.Serializable;
import java.util.Date;

public class WxBaseVo {
    private Serializable token;
    private Date tokenExpire;
    private UserInfo userInfo;

    public Serializable getToken() {
        return token;
    }

    public void setToken(Serializable token) {
        this.token = token;
    }

    public Date getTokenExpire() {
        return tokenExpire;
    }

    public void setTokenExpire(Date tokenExpire) {
        this.tokenExpire = tokenExpire;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
