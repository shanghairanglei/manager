package com.rl.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName
 * @Description 自定义User返回视图
 * @Author
 * @Date 2019/9/15 18:55
 * @Version 1.0
 **/
public class UserDto {
    //用户id
    private String tUserId;
    //用户名
    private String username;
    //密码
    private String password;
    //加密盐值
    private String salt;
    //邮箱
    private String email;
    //联系方式
    private String phone;
    //性别：1男2女
    private Integer sex;
    //年龄
    private Integer age;
    //用户状态：1有效; 2删除
    private Integer status;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //最后登录时间
    private Date lastLoginTime;
    //姓名
    private String name;
    //所属公司名称
    private String company;
    //英文名
    private String engname;
    //密码问题
    private String question;
    //密码答案
    private String answer;
    //头像图片路径
    private String img;
    //部门id
    private Integer deptId;
    //薪水
    private BigDecimal salary;
    //职位名称
    private String userpost;
    //个人简介
    private String description;
    //姓名首字母
    private String firstUpperCase;

    public String gettUserId() {
        return tUserId;
    }

    public void settUserId(String tUserId) {
        this.tUserId = tUserId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEngname() {
        return engname;
    }

    public void setEngname(String engname) {
        this.engname = engname;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getUserpost() {
        return userpost;
    }

    public void setUserpost(String userpost) {
        this.userpost = userpost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirstUpperCase() {
        return firstUpperCase;
    }

    public void setFirstUpperCase(String firstUpperCase) {
        this.firstUpperCase = firstUpperCase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDto userDto = (UserDto) o;

        if (!tUserId.equals(userDto.tUserId)) return false;
        if (!username.equals(userDto.username)) return false;
        if (!password.equals(userDto.password)) return false;
        if (!salt.equals(userDto.salt)) return false;
        if (!email.equals(userDto.email)) return false;
        if (!phone.equals(userDto.phone)) return false;
        if (!sex.equals(userDto.sex)) return false;
        if (!age.equals(userDto.age)) return false;
        if (!status.equals(userDto.status)) return false;
        if (!createTime.equals(userDto.createTime)) return false;
        if (!updateTime.equals(userDto.updateTime)) return false;
        if (!lastLoginTime.equals(userDto.lastLoginTime)) return false;
        if (!name.equals(userDto.name)) return false;
        if (!company.equals(userDto.company)) return false;
        if (!engname.equals(userDto.engname)) return false;
        if (!question.equals(userDto.question)) return false;
        if (!answer.equals(userDto.answer)) return false;
        if (!img.equals(userDto.img)) return false;
        if (!deptId.equals(userDto.deptId)) return false;
        if (!salary.equals(userDto.salary)) return false;
        if (!userpost.equals(userDto.userpost)) return false;
        if (!description.equals(userDto.description)) return false;
        return firstUpperCase.equals(userDto.firstUpperCase);
    }

    @Override
    public int hashCode() {
        int result = tUserId.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + salt.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + sex.hashCode();
        result = 31 * result + age.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + createTime.hashCode();
        result = 31 * result + updateTime.hashCode();
        result = 31 * result + lastLoginTime.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + company.hashCode();
        result = 31 * result + engname.hashCode();
        result = 31 * result + question.hashCode();
        result = 31 * result + answer.hashCode();
        result = 31 * result + img.hashCode();
        result = 31 * result + deptId.hashCode();
        result = 31 * result + salary.hashCode();
        result = 31 * result + userpost.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + firstUpperCase.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "tUserId='" + tUserId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", lastLoginTime=" + lastLoginTime +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", engname='" + engname + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", img='" + img + '\'' +
                ", deptId=" + deptId +
                ", salary=" + salary +
                ", userpost='" + userpost + '\'' +
                ", description='" + description + '\'' +
                ", firstUpperCase='" + firstUpperCase + '\'' +
                '}';
    }
}
