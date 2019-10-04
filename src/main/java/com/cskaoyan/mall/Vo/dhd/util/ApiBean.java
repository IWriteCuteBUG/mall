package com.cskaoyan.mall.vo.dhd.util;

public class ApiBean {
    String api;
    String id;
    String lable;

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    @Override
    public String toString() {
        return "ApiBean{" +
                "api='" + api + '\'' +
                ", id='" + id + '\'' +
                ", lable='" + lable + '\'' +
                '}';
    }
}
