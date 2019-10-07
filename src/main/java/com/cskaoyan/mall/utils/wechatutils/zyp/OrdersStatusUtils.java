package com.cskaoyan.mall.utils.wechatutils.zyp;

public class OrdersStatusUtils {
    public static String statusId4Status(Short id) {
        String status = null;
        if (id == 101) {
            status = "未付款";
        }

        if (id == 102) {
            status = "已取消(用户)";
        }

        if (id == 103) {
            status = "已取消(系统)";
        }

        if (id == 201) {
            status = "已付款";
        }

        if (id == 202) {
            status = "申请退款";
        }

        if (id == 203) {
            status = "已退款";
        }

        if (id == 301) {
            status = "已发货";
        }

        if (id == 401) {
            status = "已收货(系统)";
        }

        if (id == 402) {
            status = "已收货(用户)";
        }

        return status;
    }
}
