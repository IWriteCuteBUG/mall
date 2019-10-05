package com.cskaoyan.mall.vo.adminvo.voSJB;

import com.cskaoyan.mall.bean.Address;

import java.util.List;

public class AddressListAndTotalVo {
    private List<Address> addressList;
    private int total;

    @Override
    public String toString() {
        return "AddressListAndTotalVo{" +
                "addressList=" + addressList +
                ", total=" + total +
                '}';
    }

    public AddressListAndTotalVo(List<Address> addressList, int total) {
        this.addressList = addressList;
        this.total = total;
    }

    public AddressListAndTotalVo() {
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
