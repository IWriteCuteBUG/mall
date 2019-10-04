package com.cskaoyan.mall.service.admin;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.GoodsMapper;
import com.cskaoyan.mall.mapper.GrouponMapper;
import com.cskaoyan.mall.mapper.GrouponRulesMapper;
import com.cskaoyan.mall.service.GrouponsService;
import com.cskaoyan.mall.vo.tvo.GrouponsVo;
import com.cskaoyan.mall.vo.tvo.GrouponsVoInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GrouponsServiceImpl implements GrouponsService {

    @Autowired
    GrouponMapper grouponMapper;

    @Autowired
    GrouponRulesMapper grouponRulesMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public GrouponsVo getGrouponActive(int page, int limit, String sort, String order) {
        GrouponRulesExample grouponRulesExample = new GrouponRulesExample();
        grouponRulesExample.createCriteria().andIdIsNotNull();
        String orderby = sort + " " +order;
        PageHelper.startPage(page, limit, orderby);
        List<GrouponRules> grouponRules = grouponRulesMapper.selectByExample(grouponRulesExample);
        GrouponsVo grouponsVo = new GrouponsVo();
        grouponsVo.setTotal(grouponRules.size());
        List<GrouponsVoInfo> list = new ArrayList<>();
        for (GrouponRules grouponRule : grouponRules) {
            Integer goodsId = grouponRule.getGoodsId();
            Integer id = grouponRule.getId();
            Goodss goods = goodsMapper.queryGoodsContainsGallery(goodsId);
            GrouponExample grouponExample = new GrouponExample();
            grouponExample.createCriteria().andRulesIdEqualTo(id);
            List<Groupon> groupons = grouponMapper.selectByExample(grouponExample);
            GrouponsVoInfo grouponsVoInfo = new GrouponsVoInfo();
            grouponsVoInfo.setGoods(goods);
            if (!groupons.isEmpty()){
                grouponsVoInfo.setGroupon(groupons.get(0));
            }
            int[] s = new int[]{};
            grouponsVoInfo.setSubGroupons(s);
            grouponsVoInfo.setRules(grouponRule);
            list.add(grouponsVoInfo);
        }
        grouponsVo.setItems(list);
        return grouponsVo;
    }
}
