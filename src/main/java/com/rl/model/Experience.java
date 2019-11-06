package com.rl.model;

import java.util.Date;

public class Experience {
    private Integer eId;

    private String tUserId;

    private String company;

    private Date cStarttime;

    private Date cEndtime;

    private Integer cDept;

    private String cResponsibility;

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String gettUserId() {
        return tUserId;
    }

    public void settUserId(String tUserId) {
        this.tUserId = tUserId == null ? null : tUserId.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public Date getcStarttime() {
        return cStarttime;
    }

    public void setcStarttime(Date cStarttime) {
        this.cStarttime = cStarttime;
    }

    public Date getcEndtime() {
        return cEndtime;
    }

    public void setcEndtime(Date cEndtime) {
        this.cEndtime = cEndtime;
    }

    public Integer getcDept() {
        return cDept;
    }

    public void setcDept(Integer cDept) {
        this.cDept = cDept;
    }

    public String getcResponsibility() {
        return cResponsibility;
    }

    public void setcResponsibility(String cResponsibility) {
        this.cResponsibility = cResponsibility == null ? null : cResponsibility.trim();
    }
}