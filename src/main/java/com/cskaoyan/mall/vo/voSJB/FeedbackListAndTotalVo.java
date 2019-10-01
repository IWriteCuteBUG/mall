package com.cskaoyan.mall.vo.voSJB;


import java.util.List;

public class FeedbackListAndTotalVo {
    private List<FeedbackReplaceVo> feedbackList;
    private int total;

    public FeedbackListAndTotalVo() {
    }

    public FeedbackListAndTotalVo(List<FeedbackReplaceVo> feedbackList, int total) {
        this.feedbackList = feedbackList;
        this.total = total;
    }

    public List<FeedbackReplaceVo> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<FeedbackReplaceVo> feedbackList) {
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
