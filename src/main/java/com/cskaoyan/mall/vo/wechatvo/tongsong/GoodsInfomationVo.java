package com.cskaoyan.mall.vo.wechatvo.tongsong;

import com.cskaoyan.mall.bean.GoodsSpecification;
import org.hibernate.validator.constraints.URL;

import java.util.List;

public class GoodsInfomationVo {
    /*specificationList":[
    {
        "name":"规格名",
            "valueList":[
        {
            "id":433,
                "goodsId":1181065,
                "specification":"规格名",
                "value":"规格值",
                "picUrl":"http://192.168.2.100:8081/wx/storage/fetch/uraallxnzat9lqni7qg4.jpg",
                "addTime":"2019-10-02 04:56:05",
                "updateTime":"2019-10-02 04:56:05",
                "deleted":false
        }
                ]
    },*/
    private String name;
    private List<GoodsSpecification> valueList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GoodsSpecification> getValueList() {
        return valueList;
    }

    public void setValueList(List<GoodsSpecification> valueList) {
        this.valueList = valueList;
    }
}
