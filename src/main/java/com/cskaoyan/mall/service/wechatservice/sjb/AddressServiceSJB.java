package com.cskaoyan.mall.service.wechatservice.sjb;

import com.cskaoyan.mall.bean.Address;

import java.util.List;

public interface AddressServiceSJB {
    List<Address> getAddressesByUserId(int userId);

    Address getAddressById(int id);

    int addressDelete(int i);

    int updateAddressById(Address address);
}
