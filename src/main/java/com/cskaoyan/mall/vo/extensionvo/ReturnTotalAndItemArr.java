package com.cskaoyan.mall.vo.extensionvo;

public class ReturnTotalAndItemArr<T> {
    private long total;
    private T[] items;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public T[] getItems() {
        return items;
    }

    public void setItems(T[] items) {
        this.items = items;
    }
}
