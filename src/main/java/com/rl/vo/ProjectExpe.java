package com.rl.vo;

import com.rl.utils.GlobleService;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author lzw
 * @date 2019/9/30 9:38
 */
public class ProjectExpe {
    private Integer eId;

    private String tUserId;

    private String company;

    private Date cStarttime;

    private Date cEndtime;

    private Integer cDept;

    private String cResponsibility;

    private Integer id;

    private String pName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pStarttime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pEndtime;

    private String pCompany;

    private String pRole;

    private String pIntro;

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
        this.tUserId = tUserId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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
        this.cResponsibility = cResponsibility;
    }

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
        this.pName = pName;
    }

    public String getpStarttime() {
        return GlobleService.getDateString(pStarttime);
    }

    public void setpStarttime(Date pStarttime) {
        this.pStarttime = pStarttime;
    }

    public String getpEndtime() {
        return GlobleService.getDateString(pEndtime);
    }

    public void setpEndtime(Date pEndtime) {
        this.pEndtime = pEndtime;
    }

    public String getpCompany() {
        return pCompany;
    }

    public void setpCompany(String pCompany) {
        this.pCompany = pCompany;
    }

    public String getpRole() {
        return pRole;
    }

    public void setpRole(String pRole) {
        this.pRole = pRole;
    }

    public String getpIntro() {
        return pIntro;
    }

    public void setpIntro(String pIntro) {
        this.pIntro = pIntro;
    }
}
