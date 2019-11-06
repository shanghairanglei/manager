package com.rl.model;

import java.util.Date;

public class Project {
    private Integer id;

    private String pName;

    private Date pStarttime;

    private Date pEndtime;

    private String pCompany;

    private String pRole;

    private Integer eId;

    private String pIntro;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public Date getpStarttime() {
        return pStarttime;
    }

    public void setpStarttime(Date pStarttime) {
        this.pStarttime = pStarttime;
    }

    public Date getpEndtime() {
        return pEndtime;
    }

    public void setpEndtime(Date pEndtime) {
        this.pEndtime = pEndtime;
    }

    public String getpCompany() {
        return pCompany;
    }

    public void setpCompany(String pCompany) {
        this.pCompany = pCompany == null ? null : pCompany.trim();
    }

    public String getpRole() {
        return pRole;
    }

    public void setpRole(String pRole) {
        this.pRole = pRole == null ? null : pRole.trim();
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String getpIntro() {
        return pIntro;
    }

    public void setpIntro(String pIntro) {
        this.pIntro = pIntro == null ? null : pIntro.trim();
    }
}