package com.cskaoyan.mall.service.adminservice.admin.ImplSJB;

import com.cskaoyan.mall.bean.Feedback;
import com.cskaoyan.mall.bean.FeedbackExample;
import com.cskaoyan.mall.mapper.FeedbackMapper;
import com.cskaoyan.mall.service.adminservice.serviceSJB.FeedbackService;
import com.cskaoyan.mall.vo.adminvo.voSJB.FeedbackListAndTotalVo;
import com.cskaoyan.mall.vo.adminvo.voSJB.FeedbackReplaceVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    FeedbackMapper feedbackMapper;

    @Override
    public FeedbackListAndTotalVo queryFeedbacksByPage(int page, int limit, String username, String sortcolnum, String order, String id) {
        PageHelper.startPage(page, limit);
        FeedbackExample example = new FeedbackExample();
        String sortOrder = sortcolnum + " " + order;
        example.setOrderByClause(sortOrder);
        List<Feedback> feedbackList = null;
        int total = 0;
        int fid = 0;
        FeedbackExample.Criteria criteria = example.createCriteria();
        if(!(id == null || "".equals(id.trim()))){
            fid = Integer.parseInt(id);
        }
        if(fid != 0){
            criteria.andIdEqualTo(fid);
        }
        if(!(username == null || "".equals(username.trim()))){
            criteria.andUsernameLike("%" + username + "%");
        }
        feedbackList = feedbackMapper.selectByExample(example);
        total = (int) feedbackMapper.countByExample(example);
        return new FeedbackListAndTotalVo(feedbackList, total);
    }

    public static void feedbackReplace(FeedbackReplaceVo replaceVo, Feedback feedback){
        replaceVo.setId(feedback.getId());
        replaceVo.setUserId(feedback.getUserId());
        replaceVo.setUsername(feedback.getUsername());
        replaceVo.setMobile(feedback.getMobile());
        replaceVo.setFeedType(feedback.getFeedType());
        replaceVo.setContent(feedback.getContent());
        replaceVo.setStatus(feedback.getStatus());
        replaceVo.setHasPicture(feedback.getHasPicture());
        replaceVo.setAddTime(feedback.getAddTime());
        replaceVo.setUpdateTime(feedback.getUpdateTime());
        replaceVo.setDeleted(feedback.getDeleted());
    }

    @Override
    public int queryTotalNum() {
        return (int)feedbackMapper.countByExample(new FeedbackExample());
    }
}
