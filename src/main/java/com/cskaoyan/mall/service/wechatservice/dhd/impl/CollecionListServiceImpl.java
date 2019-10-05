package com.cskaoyan.mall.service.wechatservice.dhd.impl;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Collect;
import com.cskaoyan.mall.bean.CollectExample;
import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.mapper.CollectMapper;
import com.cskaoyan.mall.mapper.GoodsMapper;
import com.cskaoyan.mall.vo.wechatvo.dhd.CollectListVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollecionListServiceImpl implements CollecionListService {
    @Autowired
    CollectMapper collectMapper;
    @Autowired
    GoodsMapper goodsMapper;
    @Override
    public BaseRespVo colleciontList(int userid, int type, int page, int size) {

        CollectExample collectExample = new CollectExample();
        collectExample.createCriteria().andUserIdEqualTo(userid);
        List<Collect> collects = collectMapper.selectByExample(collectExample);
        ArrayList<Goods> goods = new ArrayList<>();
        PageHelper.startPage(page,size);
        for (Collect collect : collects) {
            Goods goods1 = goodsMapper.selectByPrimaryKey(collect.getValueId());
            goods.add(goods1);
        }
        PageInfo<Goods> goodsPageInfo = new PageInfo<>(goods);

        long total = goodsPageInfo.getTotal();
        double ceil = Math.ceil((total /(double) size));
        CollectListVo collectListVo = new CollectListVo();
        collectListVo.setCollectList( goods);
        collectListVo.setTotalPages((int) ceil);
        BaseRespVo ok = BaseRespVo.ok(collectListVo);
        return ok;
    }
}
