package com.cskaoyan.mall.utils.wechatutils.ljw;

import java.lang.reflect.Field;

public class   AssignUtils {



    public static Object assign(Object class1,Object class2) {
        Class clazz1 = class1.getClass();
        Class clazz2 = class2.getClass();
        //  获取两个实体类的所有属性
        Field[] fields1 = clazz1.getDeclaredFields();
        Field[] fields2 = clazz2.getDeclaredFields();
        // 遍历class1Bean，获取逐个属性值，然后遍历class2Bean查找是否有相同的属性，如有相同则赋值
        for (Field f1 : fields1) {
            if(f1.getName().equals("id")){
                continue;
            }

            //设置访问权限
            f1.setAccessible(true);
            Object value = null;
            try {
                value = f1.get(class1);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            for (Field f2 : fields2) {
                if(f1.getName().equals(f2.getName())){
                    //设置访问权限
                    f2.setAccessible(true);
                    try {
                        f2.set(class2,value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return  class2;
    }

        }


