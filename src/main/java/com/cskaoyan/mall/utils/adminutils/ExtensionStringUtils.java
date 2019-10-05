package com.cskaoyan.mall.utils.adminutils;

/*
* 判断字符串为空
* */
public class ExtensionStringUtils {
    public static Boolean isEmpty(String s) {
        return "".equals(s) || s == null;
    }
}
