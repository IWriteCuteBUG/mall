package com.cskaoyan.mall.vo.wechatvo.tongsong;

import com.cskaoyan.mall.utils.wechatutils.tangsong.OptionUtils;

import java.util.List;

public class OrderVo {
    private String orderStatusText;
    private boolean isGroupin;
    private String orderSn;
    private int actualPrice;
    private List goodsList;
    private OptionUtils handleOption;
    private int id;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOrderStatusText() {
        return orderStatusText;
    }

    public void setOrderStatusText(String orderStatusText) {
        this.orderStatusText = orderStatusText;
    }

    public boolean isGroupin() {
        return isGroupin;
    }

    public void setGroupin(boolean groupin) {
        isGroupin = groupin;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public int getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(int actualPrice) {
        this.actualPrice = actualPrice;
    }

    public List getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List goodsList) {
        this.goodsList = goodsList;
    }

    public OptionUtils getHandleOption() {
        return handleOption;
    }

    public void setHandleOption(OptionUtils handleOption) {
        this.handleOption = handleOption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    /*"orderStatusText":"未付款",
            "isGroupin":true,
            "orderSn":"20191006982916",
            "actualPrice":-12665,
            "goodsList":[
    {

    }
                ],
                        "id":372,
                        "handleOption":{
        "cancel":true,
                "delete":false,
                "pay":true,
                "comment":false,
                "confirm":false,
                "refund":false,
                "rebuy":false
    }*/
}
