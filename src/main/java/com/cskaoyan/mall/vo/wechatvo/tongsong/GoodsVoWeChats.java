package com.cskaoyan.mall.vo.wechatvo.tongsong;

public class GoodsVoWeChats {
    /*"goods":{
        "id":1023032,
                "name":"纯棉色织缎纹四件套",
                "brief":"色织缎纹工艺，亲肤舒适",
                "picUrl":"http://yanxuan.nosdn.127.net/e0b928ada728c140f6965bb41f47407b.png",
                "counterPrice":469,
                "retailPrice":449*/
    int id;
    String name;
    String brief;
    String picUrl;
    int counterPrice;
    int retailPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getCounterPrice() {
        return counterPrice;
    }

    public void setCounterPrice(int counterPrice) {
        this.counterPrice = counterPrice;
    }

    public int getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(int retailPrice) {
        this.retailPrice = retailPrice;
    }
}
