package com.cskaoyan.mall.service.wechatservice.sjb.impl;

import com.cskaoyan.mall.bean.Comment;
import com.cskaoyan.mall.bean.CommentExample;
import com.cskaoyan.mall.mapper.CommentMapper;
import com.cskaoyan.mall.service.wechatservice.sjb.CommentServiceSJB;
import com.cskaoyan.mall.vo.wechatvo.sjb.CommentListReqVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceSJBImpl implements CommentServiceSJB {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public int insertComment(Comment comment) {
        return commentMapper.insertCommentWithoutId(comment);
    }

    @Override
    public List<Comment> queryCommentsByPage(CommentListReqVo vo) {
        PageHelper.startPage(vo.getPage(), vo.getSize());
        CommentExample example = new CommentExample();
        CommentExample.Criteria criteria = example.createCriteria();
        criteria.andValueIdEqualTo(vo.getValueId());
        criteria.andTypeEqualTo((byte)vo.getType());
        return commentMapper.selectByExample(example);
    }
}
