package com.cskaoyan.mall.service.wechatservice.sjb;

import com.cskaoyan.mall.bean.Footprint;
import com.cskaoyan.mall.vo.wechatvo.sjb.FootprintListToolVo;

import java.util.List;

public interface FootprintServiceSJB {

    List<FootprintListToolVo> queryFootprintAndGoodsMultiById(int page, int size, int userId);

    int queryTotalFootprintByUserId(int userId);

    int addFootprintWithoutId(Footprint footprint);
}
