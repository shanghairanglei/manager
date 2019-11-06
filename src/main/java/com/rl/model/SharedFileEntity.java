package com.rl.model;

import java.util.Date;

/**
 * @ClassName
 * @Description 文件实体对象
 * @Author
 * @Date 2019/9/3 13:26
 * @Version 1.0
 **/
public class SharedFileEntity {
    //文件id
    private Integer fileId;
    //文件上传时间
    private Date fileCreatedate;
    //文件删除时间
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
    //姓名
    private String name;

    public SharedFileEntity() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SharedFileEntity that = (SharedFileEntity) o;
        if (!fileId.equals(that.fileId)) return false;
        if (!fileCreatedate.equals(that.fileCreatedate)) return false;
        if (!fileDeletedate.equals(that.fileDeletedate)) return false;
        if (!filePath.equals(that.filePath)) return false;
        if (!fileReadaccount.equals(that.fileReadaccount)) return false;
        if (!filePriority.equals(that.filePriority)) return false;
        if (!fileKinds.equals(that.fileKinds)) return false;
        if (!fileStatus.equals(that.fileStatus)) return false;
        if (!actionId.equals(that.actionId)) return false;
        if (!fileName.equals(that.fileName)) return false;
        if (!fileUploader.equals(that.fileUploader)) return false;
        if (!tUserId.equals(that.tUserId)) return false;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = fileId.hashCode();
        result = 31 * result + fileCreatedate.hashCode();
        result = 31 * result + fileDeletedate.hashCode();
        result = 31 * result + filePath.hashCode();
        result = 31 * result + fileReadaccount.hashCode();
        result = 31 * result + filePriority.hashCode();
        result = 31 * result + fileKinds.hashCode();
        result = 31 * result + fileStatus.hashCode();
        result = 31 * result + actionId.hashCode();
        result = 31 * result + fileName.hashCode();
        result = 31 * result + fileUploader.hashCode();
        result = 31 * result + tUserId.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "SharedFileEntity{" +
                "fileId=" + fileId +
                ", fileCreatedate=" + fileCreatedate +
                ", fileDeletedate=" + fileDeletedate +
                ", filePath='" + filePath + '\'' +
                ", fileReadaccount=" + fileReadaccount +
                ", filePriority=" + filePriority +
                ", fileKinds=" + fileKinds +
                ", fileStatus=" + fileStatus +
                ", actionId=" + actionId +
                ", fileName='" + fileName + '\'' +
                ", fileUploader='" + fileUploader + '\'' +
                ", tUserId='" + tUserId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

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
        this.filePath = filePath;
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
        this.fileName = fileName;
    }

    public String getFileUploader() {
        return fileUploader;
    }

    public void setFileUploader(String fileUploader) {
        this.fileUploader = fileUploader;
    }

    public String gettUserId() {
        return tUserId;
    }

    public void settUserId(String tUserId) {
        this.tUserId = tUserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SharedFileEntity(Integer fileId, Date fileCreatedate, Date fileDeletedate, String filePath, Integer fileReadaccount, Integer filePriority, Integer fileKinds, Integer fileStatus, Integer actionId, String fileName, String fileUploader, String tUserId, String name) {
        this.fileId = fileId;
        this.fileCreatedate = fileCreatedate;
        this.fileDeletedate = fileDeletedate;
        this.filePath = filePath;
        this.fileReadaccount = fileReadaccount;
        this.filePriority = filePriority;
        this.fileKinds = fileKinds;
        this.fileStatus = fileStatus;
        this.actionId = actionId;
        this.fileName = fileName;
        this.fileUploader = fileUploader;
        this.tUserId = tUserId;
        this.name = name;
    }
}
