package com.cskaoyan.mall.vo.extensionvo;

import java.util.List;

public class ToWeb<T> {
    public static AdvertList toWeb(int total, List lists) {
        AdvertList advertList = new AdvertList();
        advertList.setTotal(total);
        advertList.setItems(lists);
        return advertList;
    }
}
