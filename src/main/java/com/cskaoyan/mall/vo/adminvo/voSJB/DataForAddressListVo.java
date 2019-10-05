package com.cskaoyan.mall.vo.adminvo.voSJB;

import com.cskaoyan.mall.bean.Address;


import java.util.List;

public class DataForAddressListVo {
    private int total;//total代表地址总数
    private List<Address> items;

    @Override
    public String toString() {
        return "DataForAddressListVo{" +
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

    public List<Address> getItems() {
        return items;
    }

    public void setItems(List<Address> items) {
        this.items = items;
    }

    public DataForAddressListVo(int total, List<Address> items) {
        this.total = total;
        this.items = items;
    }

    public DataForAddressListVo() {
    }
}
