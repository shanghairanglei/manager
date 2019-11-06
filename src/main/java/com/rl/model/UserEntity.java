package com.rl.model;


import com.rl.utils.GlobleService;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName
 * @Description TODO
 * @Author
 * @Date 2019/8/27 18:02
 * @Version 1.0
 **/
public class UserEntity {
        private  Integer id;
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
        @DateTimeFormat(pattern = "yyyy-MM-dd")
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
        //部门名称
        private String deptName;
        //薪水
        private BigDecimal salary;
        //职位名称
        private String userpost;
        //个人简介
        private String description;

        private Integer teamId;

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

    public String getCreateTime() {
        return GlobleService.getDateString(createTime);
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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", tUserId='" + tUserId + '\'' +
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
                ", deptName='" + deptName + '\'' +
                ", salary=" + salary +
                ", userpost='" + userpost + '\'' +
                ", description='" + description + '\'' +
                ", teamId=" + teamId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public UserEntity(Integer id, String tUserId, String username, String password, String salt, String email, String phone, Integer sex, Integer age, Integer status, Date createTime, Date updateTime, Date lastLoginTime, String name, String company, String engname, String question, String answer, String img, Integer deptId, String deptName, BigDecimal salary, String userpost, String description, Integer teamId) {
        this.id = id;
        this.tUserId = tUserId;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.age = age;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.lastLoginTime = lastLoginTime;
        this.name = name;
        this.company = company;
        this.engname = engname;
        this.question = question;
        this.answer = answer;
        this.img = img;
        this.deptId = deptId;
        this.deptName = deptName;
        this.salary = salary;
        this.userpost = userpost;
        this.description = description;
        this.teamId = teamId;
    }

    public UserEntity() {
    }
}
