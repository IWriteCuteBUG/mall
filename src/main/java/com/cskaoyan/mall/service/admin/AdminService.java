package com.cskaoyan.mall.service.admin;

import com.cskaoyan.mall.bean.BaseRespVo;

public interface AdminService {
    BaseRespVo adminListInfo(int page, int limit, String username);
}
