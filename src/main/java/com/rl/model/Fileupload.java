package com.rl.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Fileupload {
    //文件id
    private Integer fileId;
    //文件上传时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fileCreatedate;
    //文件删除时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fileDeletedate;
    //文件路径
    private String filePath;
    //文件被浏览次数
    private Integer fileReadaccount;
    //文件优先级(0轻1重2缓3急)
    private Integer filePriority;
    //文件种类(0工作计划文件1分享文件2简历文件3财务文件)
    private Integer fileKinds;
    //共享文件状态(0回收站状态1正常)
    private Integer fileStatus;
    //操作记录id
    private Integer actionId;
    //文件名称
    private String fileName;
    //文件上传者
    private String fileUploader;
    //用户id
    private String tUserId;

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public Date getFileCreatedate() {
        return fileCreatedate;
    }

    public void setFileCreatedate(Date fileCreatedate) {
        this.fileCreatedate = fileCreatedate;
    }

    public Date getFileDeletedate() {
        return fileDeletedate;
    }

    public void setFileDeletedate(Date fileDeletedate) {
        this.fileDeletedate = fileDeletedate;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public Integer getFileReadaccount() {
        return fileReadaccount;
    }

    public void setFileReadaccount(Integer fileReadaccount) {
        this.fileReadaccount = fileReadaccount;
    }

    public Integer getFilePriority() {
        return filePriority;
    }

    public void setFilePriority(Integer filePriority) {
        this.filePriority = filePriority;
    }

    public Integer getFileKinds() {
        return fileKinds;
    }

    public void setFileKinds(Integer fileKinds) {
        this.fileKinds = fileKinds;
    }

    public Integer getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(Integer fileStatus) {
        this.fileStatus = fileStatus;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFileUploader() {
        return fileUploader;
    }

    public void setFileUploader(String fileUploader) {
        this.fileUploader = fileUploader == null ? null : fileUploader.trim();
    }

    public String gettUserId() {
        return tUserId;
    }

    public void settUserId(String tUserId) {
        this.tUserId = tUserId == null ? null : tUserId.trim();
    }
}