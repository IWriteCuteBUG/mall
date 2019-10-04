package com.cskaoyan.mall.exception;

import com.cskaoyan.mall.bean.BaseRespVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExtensionExceptionHandler {
    @ExceptionHandler(ExtensionCouponDiscountException.class)
    @ResponseBody
    public BaseRespVo ExceptionHandle(ExtensionCouponDiscountException e) {
        return BaseRespVo.baseRespErr(402,e.getMessage());
    }
}
