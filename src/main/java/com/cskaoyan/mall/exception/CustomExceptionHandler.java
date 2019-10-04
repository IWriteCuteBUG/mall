package com.cskaoyan.mall.exception;

import com.cskaoyan.mall.bean.BaseRespVo;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(AuthorizationException.class)
    @ResponseBody
    public BaseRespVo authorizationExceptionHanle(AuthorizationException e){
        BaseRespVo<String> stringBaseRespVo = new BaseRespVo<>();
        stringBaseRespVo.setErrno(605);
        stringBaseRespVo.setErrmsg("账号或密码输入错误");
        return stringBaseRespVo;
    }


    @ExceptionHandler(IncorrectCredentialsException.class)
    @ResponseBody
    public BaseRespVo authorizationExceptionHandler(IncorrectCredentialsException e){
        BaseRespVo<String> stringBaseRespVo = new BaseRespVo<>();
        stringBaseRespVo.setErrno(605);
        stringBaseRespVo.setErrmsg("账号或密码输入错误");
        return stringBaseRespVo;
    }
}
