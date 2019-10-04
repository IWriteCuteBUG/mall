package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.service.ConfigerService;
import com.cskaoyan.mall.vo.tvo.ConfigerVo;
import com.cskaoyan.mall.vo.tvo.ConfigerVoExpress;
import com.cskaoyan.mall.vo.tvo.ConfigerVoOrder;
import com.cskaoyan.mall.vo.tvo.ConfigerVoWx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigerController {

    @Autowired
    ConfigerService configerService;

    @RequestMapping(value = "/admin/config/mall", method = {RequestMethod.GET})
    public BaseRespVo queryMallConfig(){
        ConfigerVo configerVo = configerService.queryMallConfig();
        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();
        objectBaseRespVo.setErrno(0);
        objectBaseRespVo.setData(configerVo);
        objectBaseRespVo.setErrmsg("成功");
        return objectBaseRespVo;
    }


    @RequestMapping(value = "admin/config/mall", method = {RequestMethod.POST})
    public BaseRespVo updateMallConfig(@RequestBody ConfigerVo configerVo){
        boolean flag = configerService.updateMallConfig(configerVo);
        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();
        objectBaseRespVo.setData(null);
        objectBaseRespVo.setErrmsg("成功");
        return objectBaseRespVo;
    }


    @RequestMapping(value = "/admin/config/express", method = {RequestMethod.GET})
    public BaseRespVo queryMallConfigExpress(){
        ConfigerVoExpress configerVoExpress = configerService.queryConfigExpress();
        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();
        objectBaseRespVo.setErrno(0);
        objectBaseRespVo.setData(configerVoExpress);
        objectBaseRespVo.setErrmsg("成功");
        return objectBaseRespVo;
    }

    @RequestMapping(value = "/admin/config/express", method = {RequestMethod.POST})
    public BaseRespVo updateMallConfigExpress(@RequestBody ConfigerVoExpress configerVoExpress){
        boolean flag = configerService.updateMallConfigExpress(configerVoExpress);
        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();
        objectBaseRespVo.setData(null);
        objectBaseRespVo.setErrmsg("成功");
        return objectBaseRespVo;
    }
    @RequestMapping(value = "/admin/config/order", method = {RequestMethod.GET})
    public BaseRespVo queryMallConfigOrder(){
        ConfigerVoOrder configerVoOrder = configerService.queryMallConfigOrder();
        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();
        objectBaseRespVo.setErrno(0);
        objectBaseRespVo.setData(configerVoOrder);
        objectBaseRespVo.setErrmsg("成功");
        return objectBaseRespVo;
    }

    @RequestMapping(value = "/admin/config/order", method = {RequestMethod.POST})
    public BaseRespVo updateMallConfigOrder(@RequestBody ConfigerVoOrder configerVoOrder){
        boolean flag = configerService.updateMallConfigOrder(configerVoOrder);
        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();
        objectBaseRespVo.setData(null);
        objectBaseRespVo.setErrmsg("成功");
        return objectBaseRespVo;
    }

    @RequestMapping(value = "/admin/config/wx", method = {RequestMethod.GET})
    public BaseRespVo queryMallConfigWx(){
        ConfigerVoWx configerVoWx = configerService.queryMallConfigWx();
        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();
        objectBaseRespVo.setErrno(0);
        objectBaseRespVo.setData(configerVoWx);
        objectBaseRespVo.setErrmsg("成功");
        return objectBaseRespVo;
    }

    @RequestMapping(value = "/admin/config/wx", method = {RequestMethod.POST})
    public BaseRespVo updateMallConfigWx(@RequestBody ConfigerVoWx configerVoWx){
        boolean flag = configerService.updateMallConfigWx(configerVoWx);
        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();
        objectBaseRespVo.setData(null);
        objectBaseRespVo.setErrmsg("成功");
        return objectBaseRespVo;
    }
}
