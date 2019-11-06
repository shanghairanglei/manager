package com.rl.model;

import java.util.Date;

public class Education {
    private Integer id;

    private String tUserId;

    private Integer education;

    private String school;

    private String profession;

    private Date sStarttime;

    private Date sEndtime;

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
        this.tUserId = tUserId == null ? null : tUserId.trim();
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
        this.school = school == null ? null : school.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public Date getsStarttime() {
        return sStarttime;
    }

    public void setsStarttime(Date sStarttime) {
        this.sStarttime = sStarttime;
    }

    public Date getsEndtime() {
        return sEndtime;
    }

    public void setsEndtime(Date sEndtime) {
        this.sEndtime = sEndtime;
    }
}