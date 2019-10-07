package com.cskaoyan.mall.service.wechatservice.sjb;

import com.cskaoyan.mall.bean.Comment;
import com.cskaoyan.mall.vo.wechatvo.sjb.CommentListReqVo;

import java.util.List;

public interface CommentServiceSJB {
    int insertComment(Comment comment);

    List<Comment> queryCommentsByPage(CommentListReqVo vo);
}
