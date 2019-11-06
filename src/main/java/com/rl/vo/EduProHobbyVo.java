package com.rl.vo;

import com.rl.utils.GlobleService;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author lzw
 * @date 2019/9/27 9:25
 */
public class EduProHobbyVo {

    private Integer id;

    private String tUserId;
    //兴趣爱好
    private String hobby;

    private String pName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pStarttime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pEndtime;

    private String pCompany;

    private String pRole;

    private Integer eId;

    private String pIntro;

    private Integer education;

    private String school;

    private String profession;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sStarttime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sEndtime;

    private String company;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cStarttime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cEndtime;

    private Integer cDept;

    private String cResponsibility;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String gettUserId() {
        return tUserId;
    }

    public void settUserId(String tUserId) {
        this.tUserId = tUserId;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpStarttime() {
        return GlobleService.getDateString2(pStarttime);
    }

    public void setpStarttime(Date pStarttime) {
        this.pStarttime = pStarttime;
    }

    public String getpEndtime() {
        return GlobleService.getDateString2(pEndtime);
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
        this.pIntro = pIntro;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getsStarttime() {
        return GlobleService.getDateString(sStarttime);
    }

    public void setsStarttime(Date sStarttime) {
        this.sStarttime = sStarttime;
    }

    public String getsEndtime() {
        return GlobleService.getDateString(sEndtime);
    }

    public void setsEndtime(Date sEndtime) {
        this.sEndtime = sEndtime;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getcStarttime() {
        return GlobleService.getDateString(cStarttime);
    }

    public void setcStarttime(Date cStarttime) {
        this.cStarttime = cStarttime;
    }

    public String getcEndtime() {
        return GlobleService.getDateString(cEndtime);
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
}
