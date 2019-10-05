package com.cskaoyan.mall.service.adminservice.admin;

import com.cskaoyan.mall.vo.adminvo.dhd.util.CreateBean;
import com.cskaoyan.mall.bean.BaseRespVo;


public interface CreateService {
    BaseRespVo createinfo(CreateBean createBean);
}
