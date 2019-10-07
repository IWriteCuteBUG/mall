package com.cskaoyan.mall.utils.wechatutils.cly;

import java.util.ArrayList;
import java.util.List;

public class String2Number {
    public static List<Integer> string2Num(String[] strings){
        List<Integer> cly = new ArrayList<>();
        for (String string : strings) {
            int a = 0;
            char[] chars = string.toCharArray();
            for (int i = 0; i < chars.length ; i++) {
                a += chars[chars.length - 1 - i] * 10 ^ (i);
            }
              cly.add(a);
        }
        return cly;
    }
}
