package com.cskaoyan.mall.service.admin;

import com.cskaoyan.mall.bean.Admin;
import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Storage;
import com.fasterxml.jackson.databind.ser.Serializers;

public interface StorageUpdageService {
    BaseRespVo updageStorage(Storage storage);
}
