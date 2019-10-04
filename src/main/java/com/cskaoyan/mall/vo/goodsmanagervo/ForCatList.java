package com.cskaoyan.mall.vo.goodsmanagervo;

import java.util.List;

public class ForCatList {
    int value;
    String label;
    List<ForCatChildren> children;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<ForCatChildren> getChildren() {
        return children;
    }

    public void setChildren(List<ForCatChildren> children) {
        this.children = children;
    }
}
