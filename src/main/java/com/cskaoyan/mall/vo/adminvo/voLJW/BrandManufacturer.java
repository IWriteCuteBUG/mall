package com.cskaoyan.mall.vo.adminvo.voLJW;

import com.cskaoyan.mall.bean.Brand;

import java.util.List;

public class BrandManufacturer {
    int total;
    List<Brand> items;

    public BrandManufacturer(int total, List<Brand> items) {
        this.total = total;
        this.items = items;
    }

    @Override
    public String toString() {
        return "BrandManufacturer{" +
                "total=" + total +
                ", items=" + items +
                '}';
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Brand> getItems() {
        return items;
    }

    public void setItems(List<Brand> items) {
        this.items = items;
    }
}
