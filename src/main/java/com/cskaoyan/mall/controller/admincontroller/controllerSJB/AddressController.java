package com.cskaoyan.mall.controller.admincontroller.controllerSJB;


import com.cskaoyan.mall.service.adminservice.serviceSJB.AddressService;
import com.cskaoyan.mall.vo.adminvo.voSJB.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @RequestMapping("list")
    public AddressListVo list(int page, int limit, String name, String userId, String sort, String order){
        AddressListAndTotalVo vo = addressService.queryAddressesByPage(page, limit, name, userId, sort, order);
        return new AddressListVo(0, new DataForAddressListVo(vo.getTotal(), vo.getAddressList()), "no error");
    }
}
