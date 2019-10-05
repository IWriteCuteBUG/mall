package com.cskaoyan.mall.service.adminservice;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.vo.adminvo.tvo.PasswordVo;

public interface AdminService {
    BaseRespVo queryInfo(String token);

    BaseRespVo updatePassword(PasswordVo passwordVo);

    boolean queryUsername(String username);

    BaseRespVo adminListInfo(int page, int limit, String username);
}
