package com.cskaoyan.mall.bean;

import java.util.Date;

public class cskaoyan_mall_issue {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cskaoyan_mall_issue.id
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cskaoyan_mall_issue.question
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    private String question;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cskaoyan_mall_issue.answer
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    private String answer;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cskaoyan_mall_issue.add_time
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    private Date addTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cskaoyan_mall_issue.update_time
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cskaoyan_mall_issue.deleted
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    private Boolean deleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cskaoyan_mall_issue.id
     *
     * @return the value of cskaoyan_mall_issue.id
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cskaoyan_mall_issue.id
     *
     * @param id the value for cskaoyan_mall_issue.id
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cskaoyan_mall_issue.question
     *
     * @return the value of cskaoyan_mall_issue.question
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    public String getQuestion() {
        return question;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cskaoyan_mall_issue.question
     *
     * @param question the value for cskaoyan_mall_issue.question
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cskaoyan_mall_issue.answer
     *
     * @return the value of cskaoyan_mall_issue.answer
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cskaoyan_mall_issue.answer
     *
     * @param answer the value for cskaoyan_mall_issue.answer
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cskaoyan_mall_issue.add_time
     *
     * @return the value of cskaoyan_mall_issue.add_time
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cskaoyan_mall_issue.add_time
     *
     * @param addTime the value for cskaoyan_mall_issue.add_time
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cskaoyan_mall_issue.update_time
     *
     * @return the value of cskaoyan_mall_issue.update_time
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cskaoyan_mall_issue.update_time
     *
     * @param updateTime the value for cskaoyan_mall_issue.update_time
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cskaoyan_mall_issue.deleted
     *
     * @return the value of cskaoyan_mall_issue.deleted
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cskaoyan_mall_issue.deleted
     *
     * @param deleted the value for cskaoyan_mall_issue.deleted
     *
     * @mbg.generated Mon Sep 30 14:11:59 CST 2019
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}