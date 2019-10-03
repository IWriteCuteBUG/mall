package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.vo.tvo.PasswordVo;

public interface AdminService {
    BaseRespVo queryInfo(String token);

    BaseRespVo updatePassword(PasswordVo passwordVo);
}
