package com.cskaoyan.mall.service.wechatservice.sjb.impl;

import com.cskaoyan.mall.bean.Address;
import com.cskaoyan.mall.bean.AddressExample;
import com.cskaoyan.mall.mapper.AddressMapper;
import com.cskaoyan.mall.service.wechatservice.sjb.AddressServiceSJB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceSJBImpl implements AddressServiceSJB {
    @Autowired
    AddressMapper addressMapper;

    @Override
    public List<Address> getAddressesByUserId(int userId) {
        return addressMapper.selectExistByPrimaryKey(userId);
    }

    @Override
    public Address getAddressById(int id) {
        return addressMapper.selectByPrimaryKey(id);
    }


    @Override
    public int addressDelete(int id) {
        return addressMapper.setDeletedTrue(id);
    }

    @Override
    public int updateAddressById(Address address) {

        return addressMapper.updateAddressById(address);
    }
}
