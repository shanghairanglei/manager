package com.rl.model;

public class Dept {
    //部门id
    private Integer deptId;
    //部门名称
    private String deptName;
    //部门地址
    private String deptAddress;
    //所属公司
    private String deptCompany;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getDeptAddress() {
        return deptAddress;
    }

    public void setDeptAddress(String deptAddress) {
        this.deptAddress = deptAddress == null ? null : deptAddress.trim();
    }

    public String getDeptCompany() {
        return deptCompany;
    }

    public void setDeptCompany(String deptCompany) {
        this.deptCompany = deptCompany == null ? null : deptCompany.trim();
    }
}