package com.rl.vo;


import com.rl.utils.GlobleService;

import java.util.Date;

public class UserWorkPlans {

    private String name;

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

    private Integer deptId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        this.wpName = wpName;
    }

    public String getWpStarttime() { return wpStarttime; }

    public void setWpStarttime(String wpStarttime) { this.wpStarttime = wpStarttime; }

    public String getWpEndtime() { return wpEndtime; }

    public void setWpEndtime(String wpEndtime) {
        this.wpEndtime = wpEndtime;
    }

    public String getWpContent() {
        return wpContent;
    }

    public void setWpContent(String wpContent) {
        this.wpContent = wpContent;
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
        this.wpRemark = wpRemark;
    }

    public String getWpCreatedate() { return GlobleService.getDateString2(wpCreatedate); }

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
        this.tUserId = tUserId;
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

    public Integer getDeptId() { return deptId; }

    public void setDeptId(Integer deptId) { this.deptId = deptId; }

    public UserWorkPlans(String name, Integer wpId, String wpName, String wpStarttime, String wpEndtime, String wpContent, Integer wpKeypoint, Integer wpProspectPerformance, Integer wpActualPerformance, String wpRemark, Date wpCreatedate, Integer wpStatus, String tUserId, Integer fileId, Integer checkPoint, Integer ifSummary, Integer deptId) {
        this.name = name;
        this.wpId = wpId;
        this.wpName = wpName;
        this.wpStarttime = wpStarttime;
        this.wpEndtime = wpEndtime;
        this.wpContent = wpContent;
        this.wpKeypoint = wpKeypoint;
        this.wpProspectPerformance = wpProspectPerformance;
        this.wpActualPerformance = wpActualPerformance;
        this.wpRemark = wpRemark;
        this.wpCreatedate = wpCreatedate;
        this.wpStatus = wpStatus;
        this.tUserId = tUserId;
        this.fileId = fileId;
        this.checkPoint = checkPoint;
        this.ifSummary = ifSummary;
        this.deptId = deptId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserWorkPlans that = (UserWorkPlans) o;

        if (!name.equals(that.name)) return false;
        if (!wpId.equals(that.wpId)) return false;
        if (!wpName.equals(that.wpName)) return false;
        if (!wpStarttime.equals(that.wpStarttime)) return false;
        if (!wpEndtime.equals(that.wpEndtime)) return false;
        if (!wpContent.equals(that.wpContent)) return false;
        if (!wpKeypoint.equals(that.wpKeypoint)) return false;
        if (!wpProspectPerformance.equals(that.wpProspectPerformance)) return false;
        if (!wpActualPerformance.equals(that.wpActualPerformance)) return false;
        if (!wpRemark.equals(that.wpRemark)) return false;
        if (!wpCreatedate.equals(that.wpCreatedate)) return false;
        if (!wpStatus.equals(that.wpStatus)) return false;
        if (!tUserId.equals(that.tUserId)) return false;
        if (!fileId.equals(that.fileId)) return false;
        if (!checkPoint.equals(that.checkPoint)) return false;
        if (!ifSummary.equals(that.ifSummary)) return false;
        return deptId.equals(that.deptId);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + wpId.hashCode();
        result = 31 * result + wpName.hashCode();
        result = 31 * result + wpStarttime.hashCode();
        result = 31 * result + wpEndtime.hashCode();
        result = 31 * result + wpContent.hashCode();
        result = 31 * result + wpKeypoint.hashCode();
        result = 31 * result + wpProspectPerformance.hashCode();
        result = 31 * result + wpActualPerformance.hashCode();
        result = 31 * result + wpRemark.hashCode();
        result = 31 * result + wpCreatedate.hashCode();
        result = 31 * result + wpStatus.hashCode();
        result = 31 * result + tUserId.hashCode();
        result = 31 * result + fileId.hashCode();
        result = 31 * result + checkPoint.hashCode();
        result = 31 * result + ifSummary.hashCode();
        result = 31 * result + deptId.hashCode();
        return result;
    }

    public UserWorkPlans() {

    }

    @Override
    public String toString() {
        return "UserWorkPlans{" +
                "name='" + name + '\'' +
                ", wpId=" + wpId +
                ", wpName='" + wpName + '\'' +
                ", wpStarttime='" + wpStarttime + '\'' +
                ", wpEndtime='" + wpEndtime + '\'' +
                ", wpContent='" + wpContent + '\'' +
                ", wpKeypoint=" + wpKeypoint +
                ", wpProspectPerformance=" + wpProspectPerformance +
                ", wpActualPerformance=" + wpActualPerformance +
                ", wpRemark='" + wpRemark + '\'' +
                ", wpCreatedate=" + wpCreatedate +
                ", wpStatus=" + wpStatus +
                ", tUserId='" + tUserId + '\'' +
                ", fileId=" + fileId +
                ", checkPoint=" + checkPoint +
                ", ifSummary=" + ifSummary +
                ", deptId=" + deptId +
                '}';
    }
}
