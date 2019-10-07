package com.cskaoyan.mall.utils.wechatutils.cly;

import com.alibaba.fastjson.JSON;
import com.cskaoyan.mall.bean.Goods;

import java.util.ArrayList;
import java.util.List;

public class String2BeanListUtil {
    //需要一个String数组 以及一个实例类
    public static List<Goods> getBeanList(String[] strs, Goods object) {

        List list = new ArrayList();
        //转换bean并添加进list
        for (String s : strs) {
            list.add(JSON.parseObject(JSON.toJSONString(s), object.getClass()));
        }
        System.out.println(list.size());
        //返回objectlist
        return list;
    }
}
