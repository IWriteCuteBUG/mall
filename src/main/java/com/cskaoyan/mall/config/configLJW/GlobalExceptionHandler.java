package com.cskaoyan.mall.config.configLJW;


import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.util.utiLJW.ReturnUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice //@ControllerAdvice 该注解定义全局异常处理类
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class) //@ExceptionHandler 该注解声明异常处理方法
    public BaseRespVo defaultErrorHandler(HttpServletRequest req, Exception e, HttpServletResponse response) throws Exception {

       return ReturnUtils.fail(null,e.getMessage());

    }
}
