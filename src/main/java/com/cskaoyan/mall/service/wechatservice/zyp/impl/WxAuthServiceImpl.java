package com.cskaoyan.mall.service.wechatservice.zyp.impl;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.config.AliyunConfig;
import com.cskaoyan.mall.mapper.OrderMapper;
import com.cskaoyan.mall.mapper.UserFormidMapper;
import com.cskaoyan.mall.mapper.UserMapper;
import com.cskaoyan.mall.realm.wxtokenvo.UserInfo;
import com.cskaoyan.mall.realm.wxtokenvo.WxBaseVo;
import com.cskaoyan.mall.service.wechatservice.zyp.WxAuthService;
import com.cskaoyan.mall.utils.adminutils.ExtensionStringUtils;
import com.cskaoyan.mall.utils.wechatutils.zyp.CodeIstTrue;
import com.cskaoyan.mall.vo.wechatvo.zyp.WeChatRegisterVo;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.ResponseWrapper;
import java.io.IOException;
import java.io.Serializable;
import java.lang.System;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class WxAuthServiceImpl implements WxAuthService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    AliyunConfig aliyunConfig;

    @Override
    public Integer queryIdByUsername(String username) {
        String idString = userMapper.queryIdByUsername(username);
        Integer id = Integer.valueOf(idString);
        return id;
    }

    @Override
    public List<Order> queryOrdersByUserIdAndOrderStatus(Integer userId, Integer status) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria().andUserIdEqualTo(userId);
        ArrayList<Short> statusList = new ArrayList<>();
        if (status == 0) {
            criteria.andOrderStatusEqualTo((short) 101);
        }
        if (status == 1) {
            criteria.andOrderStatusEqualTo((short) 201);
        }
        if (status == 2) {
            criteria.andOrderStatusEqualTo((short) 301);
        }
        if (status == 3) {
            statusList.add((short) 402);
            statusList.add((short) 401);
            criteria.andOrderStatusIn(statusList);
        }
        List<Order> orderList = orderMapper.selectByExample(orderExample);
        return orderList;
    }
//  注册用户
    @Override
    public BaseRespVo insertUser(WeChatRegisterVo registerVo) {
        /*int code = registerVo.getCode();
        Session session = SecurityUtils.getSubject().getSession();
//        System.out.println(session.getId());
        Integer codeFromSession = (Integer) session.getAttribute("code");*/
        String s = userMapper.queryIdByUsername(registerVo.getUsername());
        if (!ExtensionStringUtils.isEmpty(s)) {
            return BaseRespVo.baseRespErr(702, "用户名已存在");
        }
        int userNum = userMapper.queryIdCountByMobile(registerVo.getMobile());
        if (userNum != 0) {
            return BaseRespVo.baseRespErr(702,"您的手机号已经注册，请直接登录");
        }
        Boolean codeIstTrue = CodeIstTrue.verifyCode(registerVo);
        if (!codeIstTrue) {
            return BaseRespVo.baseRespErr(702, "验证码错误");
        }
        User user = new User();
        user.setAddTime(new Date());
        user.setUsername(registerVo.getUsername());
        user.setPassword(registerVo.getPassword());
        user.setMobile(registerVo.getMobile());
        user.setNickname(registerVo.getUsername());
        int i = userMapper.insertSelective(user);
        com.cskaoyan.mall.realm.wxtokenvo.UserInfo userInfo = new UserInfo();
        userInfo.setAvatarUrl("");
        userInfo.setNickName(registerVo.getUsername());
        WxBaseVo wxBaseVo = new WxBaseVo();
        Subject subject = SecurityUtils.getSubject();
        Serializable id = subject.getSession().getId();
        wxBaseVo.setUserInfo(userInfo);
        wxBaseVo.setToken(id);
        wxBaseVo.setTokenExpire(new Date());


//        标记
        SecurityUtils.getSubject().getSession().setAttribute("userId", user.getId());
        return BaseRespVo.baseRespOk(wxBaseVo);
    }
//  手机获取验证码
    @Override
    public BaseRespVo regCaptcha(String mobile, int code) {
        String accessKeyId = aliyunConfig.getAccessKeyId();
        String accessSecret = aliyunConfig.getAccessSecret();
        String regionId = aliyunConfig.getSmsConfig().getRegionId();
        String templateCode = aliyunConfig.getSmsConfig().getTemplateCode();
        String signName = aliyunConfig.getSmsConfig().getSignName();

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",
                accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", regionId);
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            ObjectMapper objectMapper = new ObjectMapper();
            Map map = objectMapper.readValue(response.getData(), Map.class);
            String message = (String) map.get("Message");
        } catch (ServerException e) {
            return BaseRespVo.baseRespErr(702,"系统繁忙");
            //e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
            return BaseRespVo.baseRespErr(702,"系统繁忙");
        } catch (JsonMappingException e) {
            e.printStackTrace();
            return BaseRespVo.baseRespErr(702,"系统繁忙");
        } catch (IOException e) {
            e.printStackTrace();
            return BaseRespVo.baseRespErr(702,"系统繁忙");
        } catch (ClientException e) {
            e.printStackTrace();
            return BaseRespVo.baseRespErr(702,"系统繁忙");
        }
        return BaseRespVo.baseRespOk("获取验证码成功");
    }

    //密码重置
    @Override
    public BaseRespVo reset(WeChatRegisterVo weChatRegisterVo) {
        String mobile = weChatRegisterVo.getMobile();
        int userNum = userMapper.queryIdCountByMobile(mobile);
        if (userNum == 0) {
            return BaseRespVo.baseRespErr(702,"您的手机号尚未注册，请先进行注册");
        }
        Boolean codeIstTrue = CodeIstTrue.verifyCode(weChatRegisterVo);
        if (!codeIstTrue) {
            return BaseRespVo.baseRespErr(702, "验证码错误");
        }
        String password = weChatRegisterVo.getPassword();
        int i = userMapper.updateByMobile(password,mobile);
        return BaseRespVo.ok("密码重置成功！");
    }

}
