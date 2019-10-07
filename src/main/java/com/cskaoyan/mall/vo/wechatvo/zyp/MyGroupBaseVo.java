package com.cskaoyan.mall.vo.wechatvo.zyp;

public class MyGroupBaseVo<T> {
    private T data;
    private int count;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
