package com.rl.model;

import java.util.Date;

public class ActionRecord {
    //操作id
    private Integer actionId;
    //操作时间
    private Date actionTime;
    //操作种类（0删除1上传2浏览3恢复）
    private Integer actionKinds;
    //操作者
    private String actionName;
    //文件id
    private Integer fileId;

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public Date getActionTime() {
        return actionTime;
    }

    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }

    public Integer getActionKinds() {
        return actionKinds;
    }

    public void setActionKinds(Integer actionKinds) {
        this.actionKinds = actionKinds;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName == null ? null : actionName.trim();
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }
}