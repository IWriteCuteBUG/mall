package com.cskaoyan.mall.vo.adminvo.voSJB;


import com.cskaoyan.mall.bean.Feedback;

import java.util.List;

public class FeedbackListAndTotalVo {
    private List<Feedback> feedbackList;
    private int total;

    public FeedbackListAndTotalVo() {
    }

    public FeedbackListAndTotalVo(List<Feedback> feedbackList, int total) {
        this.feedbackList = feedbackList;
        this.total = total;
    }

    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "FeedbackListAndTotalVo{" +
                "feedbackList=" + feedbackList +
                ", total=" + total +
                '}';
    }


}
