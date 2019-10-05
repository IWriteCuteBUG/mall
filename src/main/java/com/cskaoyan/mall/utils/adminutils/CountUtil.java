package com.cskaoyan.mall.utils.adminutils;

import java.util.ArrayList;
import java.util.List;

public class CountUtil {
    public static List<String>  DateTimeList2DateList(List<String> loginDateTime){
        List<String> loginDate = new ArrayList<>();
        //String s = "2019-04-19 11:09:12";
        for (String s1 : loginDateTime) {
            String substring = s1.substring(0, 10);
            if (!loginDate.contains(substring)){
                loginDate.add(substring);
            }
        }

        return loginDate;
    }
}
