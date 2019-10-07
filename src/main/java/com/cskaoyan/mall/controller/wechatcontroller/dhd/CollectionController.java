package com.cskaoyan.mall.controller.wechatcontroller.dhd;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Collect;
import com.cskaoyan.mall.service.adminservice.serviceSJB.UserService;
import com.cskaoyan.mall.service.wechatservice.dhd.impl.CollecionListService;
import com.cskaoyan.mall.service.wechatservice.dhd.impl.CollectAddordeleteService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CollectionController {
    @Autowired
    CollecionListService collecionListService;
    @RequestMapping("/wx/collect/list")
    public BaseRespVo collecionyListInfo(int type, int page, int size){
        Integer userId =(Integer)SecurityUtils.getSubject().getSession().getAttribute("userId");

        /*int i = Integer.parseInt(userId1);*/
       /* int userid=1;*/
        BaseRespVo baseRespVo=collecionListService.colleciontList(userId,type,page,size);
        return baseRespVo;
    }
    @Autowired
    CollectAddordeleteService collectAddordeleteSerivce;
    @RequestMapping("/wx/collect/addordelete")
    public BaseRespVo collectionAddordeleteInfo(@RequestBody Collect collect){
        Integer userId =(Integer)SecurityUtils.getSubject().getSession().getAttribute("userId");
        collect.setUserId(userId);
        BaseRespVo baseRespVo=collectAddordeleteSerivce.addordeleteOrAdd(collect);
        return  baseRespVo;
    }

}
