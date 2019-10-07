package com.cskaoyan.mall.controller.wechatcontroller.zyp;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.service.wechatservice.zyp.WechatGrouponService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
    public BaseRespVo myGroupon(Integer ShowType, HttpServletRequest request) {
//        BaseRespVo baseRespVo = wechatGrouponService.queryGrouponByShowType(ShowType);
        String principal = (String) SecurityUtils.getSubject().getPrincipal();
        String userId1 = (String) request.getSession().getAttribute("userId");
        return null;
    }
}
