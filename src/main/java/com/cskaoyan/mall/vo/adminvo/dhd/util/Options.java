package com.cskaoyan.mall.vo.adminvo.dhd.util;

public class Options {
    int value;
    String label;

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

    @Override
    public String toString() {
        return "Options{" +
                "value=" + value +
                ", label='" + label + '\'' +
                '}';
    }
}
