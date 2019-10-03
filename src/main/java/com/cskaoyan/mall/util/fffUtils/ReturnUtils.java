package com.cskaoyan.mall.util.fffUtils;

import com.cskaoyan.mall.bean.BaseRespVo;

public class ReturnUtils {
    public static BaseRespVo ok(Object data,String msg){
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setErrmsg(msg);
        baseRespVo.setData(data);
        baseRespVo.setErrno(0);
        return baseRespVo;
    }
    public static BaseRespVo fail(Object data,String msg){
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setErrmsg(msg);
        baseRespVo.setData(data);
        baseRespVo.setErrno(1);
        return baseRespVo;
    }
}
