package com.cskaoyan.mall.service.wechatservice.zyp.impl;

import com.cskaoyan.mall.bean.Groupon;
import com.cskaoyan.mall.bean.GrouponExample;
import com.cskaoyan.mall.bean.GrouponRules;
import com.cskaoyan.mall.bean.GrouponRulesExample;
import com.cskaoyan.mall.mapper.GrouponMapper;
import com.cskaoyan.mall.mapper.GrouponRulesMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class GrouponServiceImpl {
    @Autowired
    GrouponMapper grouponMapper;
    @Autowired
    GrouponRulesMapper grouponRulesMapper;

    public void grouponService() {

//        /*int userId = 0;
//=======
//        int userId = 0;
//>>>>>>> ljw
//        int grouponRulesId = 0;
////        int grouponLinkId = 0;
//        if (grouponRulesId != 0) {
//
//<<<<<<< HEAD
//            *//*GrouponRulesExample grouponRulesExample = new GrouponRulesExample();
//            grouponRulesExample.createCriteria().andIdEqualTo(grouponRulesId);
//            List<GrouponRules> grouponRules = grouponRulesMapper.selectByExample(grouponRulesExample);*//*
//=======
//            /*GrouponRulesExample grouponRulesExample = new GrouponRulesExample();
//            grouponRulesExample.createCriteria().andIdEqualTo(grouponRulesId);
//            List<GrouponRules> grouponRules = grouponRulesMapper.selectByExample(grouponRulesExample);*/
//
////            查询团购规则的信息
//            GrouponRules grouponRules = grouponRulesMapper.selectByPrimaryKey(grouponRulesId);
//
////            查询当前团购的数量
//            GrouponExample grouponExample = new GrouponExample();
////            grouponExample.createCriteria().andRulesIdEqualTo(grouponRulesId).andGrouponIdEqualTo(grouponLinkId);
//
////            不使用grouponLinkId
//            grouponExample.createCriteria().andRulesIdEqualTo(grouponRulesId);
//            List<Groupon> groupons = grouponMapper.selectByExample(grouponExample);
//
////            在团购规则中取出团购人数需要几人
//            Integer discountMember = grouponRules.getDiscountMember();
////            当前团购的数量
//            int size = groupons.size();
////            当前团购数量小于团购人数时，加入他人的团购
//            Groupon groupon = new Groupon();
//            groupon.setOrderId(1);//需要修改
//            Integer rulesId = grouponRules.getId();
//            groupon.setRulesId(rulesId);
//            groupon.setUserId(userId);
//            Date date = new Date();
//            groupon.setAddTime(date);
//            groupon.setPayed(true);
//            groupon.setDeleted(false);
////            是否能整除,不需要整除
////            int i = size / discountMember;
////            取余
//            int i1 = size % discountMember;
//            if (i1 != 0) {
////                获取当前要参加的他人创建的团购的信息
//                Groupon groupon1 = groupons.get(0);
//
////                设置团购规则下的团购id
//                int grouponId = grouponMapper.queryMaxGrouponIdByRuleId(rulesId);
////                Integer grouponId = groupon1.getGrouponId();
//                groupon.setGrouponId(grouponId);
//
////               设置当前团购规则下的创建人Id
//                Integer userId1 = groupon1.getUserId();
//                groupon.setCreatorUserId(userId1);
//
//               进行数据库的插入操作
//                grouponMapper.insertSelective(groupon);
//            }
////            当当前团购为0或团购已满时，作为创建者加入团购
////            if (size == 0 || discountMember == size) {
////            不使用grouponLinkId
////            if (i == 0 && i1 == 0) {
//            if (i1 == 0) {
//                groupon.setCreatorUserId(userId);
//                grouponMapper.insertSelective(groupon);
//            }
//
//
//        }*/



    }
}
