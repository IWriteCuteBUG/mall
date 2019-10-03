package com.cskaoyan.mall.Vo.dhd.util;

public class CreateBean {
    String desc;
    String name;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CreateBean{" +
                "desc='" + desc + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
