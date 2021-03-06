package com.rl.model;

import com.rl.utils.GlobleService;

import java.util.Date;

public class Workplans {
    private Integer wpId;

    private String wpName;

    private String wpStarttime;

    private String wpEndtime;

    private String wpContent;

    private Integer wpKeypoint;

    private Integer wpProspectPerformance;

    private Integer wpActualPerformance;

    private String wpRemark;

    private Date wpCreatedate;

    private Integer wpStatus;

    private String tUserId;

    private Integer fileId;

    private Integer checkPoint;

    private Integer ifSummary;

    //自测绩效评估
    private Integer selfTestPerformance;

    //实际绩效评估
    private Integer selfActualPerformance;

    //管理权重
    private Integer managementWeight;

    //管理绩效测评
    private Integer managementPerformance;

    //自测总绩效
    private Integer selfTotalPerformance;

    //管理总绩效
    private Integer totalPerformance;

    public Integer getSelfTestPerformance() {
        return this.selfTestPerformance;
    }

    public void setSelfTestPerformance(Integer selfTestPerformance) {
        this.selfTestPerformance = selfTestPerformance;
    }

    public Integer getSelfActualPerformance() {
        return this.selfActualPerformance;
    }

    public void setSelfActualPerformance(Integer selfActualPerformance) {
        this.selfActualPerformance = selfActualPerformance;
    }

    public Integer getManagementWeight() {
        return this.managementWeight;
    }

    public void setManagementWeight(Integer managementWeight) {
        this.managementWeight = managementWeight;
    }

    public Integer getManagementPerformance() {
        return this.managementPerformance;
    }

    public void setManagementPerformance(Integer managementPerformance) {
        this.managementPerformance = managementPerformance;
    }

    public Integer getSelfTotalPerformance() {
        return this.selfTotalPerformance;
    }

    public void setSelfTotalPerformance(Integer selfTotalPerformance) {
        this.selfTotalPerformance = selfTotalPerformance;
    }

    public Integer getTotalPerformance() {
        return this.totalPerformance;
    }

    public void setTotalPerformance(Integer totalPerformance) {
        this.totalPerformance = totalPerformance;
    }

    public Integer getWpId() {
        return wpId;
    }

    public void setWpId(Integer wpId) {
        this.wpId = wpId;
    }

    public String getWpName() {
        return wpName;
    }

    public void setWpName(String wpName) {
        this.wpName = wpName == null ? null : wpName.trim();
    }

    public String getWpStarttime() {
        return wpStarttime;
    }

    public void setWpStarttime(String wpStarttime) {
        this.wpStarttime = wpStarttime;
    }

    public String getWpEndtime() {
        return wpEndtime;
    }

    public void setWpEndtime(String wpEndtime) {
        this.wpEndtime = wpEndtime;
    }

    public String getWpContent() {
        return wpContent;
    }

    public void setWpContent(String wpContent) {
        this.wpContent = wpContent == null ? null : wpContent.trim();
    }

    public Integer getWpKeypoint() {
        return wpKeypoint;
    }

    public void setWpKeypoint(Integer wpKeypoint) {
        this.wpKeypoint = wpKeypoint;
    }

    public Integer getWpProspectPerformance() {
        return wpProspectPerformance;
    }

    public void setWpProspectPerformance(Integer wpProspectPerformance) {
        this.wpProspectPerformance = wpProspectPerformance;
    }

    public Integer getWpActualPerformance() {
        return wpActualPerformance;
    }

    public void setWpActualPerformance(Integer wpActualPerformance) {
        this.wpActualPerformance = wpActualPerformance;
    }

    public String getWpRemark() {
        return wpRemark;
    }

    public void setWpRemark(String wpRemark) {
        this.wpRemark = wpRemark == null ? null : wpRemark.trim();
    }

    public String getWpCreatedate(){
        return GlobleService.getDateString(wpCreatedate);
    }

    public void setWpCreatedate(Date wpCreatedate) {
        this.wpCreatedate = wpCreatedate;
    }

    public Integer getWpStatus() {
        return wpStatus;
    }

    public void setWpStatus(Integer wpStatus) {
        this.wpStatus = wpStatus;
    }

    public String gettUserId() {
        return tUserId;
    }

    public void settUserId(String tUserId) {
        this.tUserId = tUserId == null ? null : tUserId.trim();
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public Integer getCheckPoint() {
        return checkPoint;
    }

    public void setCheckPoint(Integer checkPoint) {
        this.checkPoint = checkPoint;
    }

    public Integer getIfSummary() {
        return ifSummary;
    }

    public void setIfSummary(Integer ifSummary) {
        this.ifSummary = ifSummary;
    }
}