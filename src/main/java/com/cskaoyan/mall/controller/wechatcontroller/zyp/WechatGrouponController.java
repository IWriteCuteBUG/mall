package com.cskaoyan.mall.controller.wechatcontroller.zyp;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.service.wechatservice.zyp.WechatGrouponService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("wx/groupon")
public class WechatGrouponController {
    @Autowired
    WechatGrouponService wechatGrouponService;

    @RequestMapping("my")
    public BaseRespVo myGroupon(Integer showType) {
        if (showType == null) {
            showType = 0;
        }
//        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        BaseRespVo baseRespVo = wechatGrouponService.queryGrouponByShowType(showType);
        return baseRespVo;
    }

    @RequestMapping("detail")
    public BaseRespVo detailGroupon(Integer grouponId) {
        if (grouponId == null) {
            grouponId = 0;
        }
        BaseRespVo baseRespVo = wechatGrouponService.queryGrouponDetailByShowType(grouponId);
        return baseRespVo;
    }

    @RequestMapping("list")
    public BaseRespVo listGroupon(Integer page,Integer size) {
        BaseRespVo baseRespVo = wechatGrouponService.queryGrouponlist(page,size);
        return baseRespVo;
    }
}
