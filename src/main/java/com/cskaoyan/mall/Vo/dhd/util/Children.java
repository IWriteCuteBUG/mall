package com.cskaoyan.mall.vo.dhd.util;

import java.util.List;

public class Children<T> {
    String id;
    String lable;
    List<T> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Children{" +
                "id='" + id + '\'' +
                ", lable='" + lable + '\'' +
                ", children=" + children +
                '}';
    }
}
