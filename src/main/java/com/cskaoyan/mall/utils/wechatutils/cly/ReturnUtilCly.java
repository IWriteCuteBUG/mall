package com.cskaoyan.mall.utils.wechatutils.cly;

import com.cskaoyan.mall.bean.BaseRespVo;

public class ReturnUtilCly {
    public static BaseRespVo back(Object data, String msg, int num){
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setErrmsg(msg);
        baseRespVo.setData(data);
        baseRespVo.setErrno(num);
        return baseRespVo;
    }
}
