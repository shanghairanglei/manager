package com.rl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rl.dto.UserDto;
import com.rl.mapper.usermapper.UserMapper;
import com.rl.model.User;
import com.rl.model.UserEntity;
import com.rl.model.UserKey;
import com.rl.service.UserService;
import com.rl.utils.GlobleService;
import com.rl.vo.EduProHobbyVo;
import com.rl.vo.UserDept;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insert(User record) {
        return 0;
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }


    @Override
    public User selectByNamePwd(String username, String password) {
        return userMapper.selectUserByNamePwd(username,password);
    }

    @Override
    public User selectByName(String username) {
        return userMapper.selectUserByName(username);
    }

    @Override
    public User selectUserById(int id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }

    /*查询所有人员列表*/
    @Override
    public List<UserEntity> selectUserList() {
        return userMapper.selectUserList();
    }

    /*添加员工*/
    @Transactional
    @Override
    public Integer addUser(UserEntity user) {
        String s = UUID.randomUUID().toString().substring(0, 12);
        user.settUserId(s);
        user.setStatus(1);
//        Date date=new Date();
//        user.setCreateTime(date);
        user.setImg("//project//image//2.png");
        Integer result = userMapper.addUser(user);
        //给用户添加角色id
        userMapper.addUserRole(user.gettUserId(),"1");
        return result;
    }

    @Override
    public Integer addUserRole(String tUserId, String roleId) {
        return userMapper.addUserRole(tUserId,roleId);
    }

    /*修改员工基本信息*/
    @Transactional
    @Override
    public Integer updateUserByEmId(UserEntity user) {
        return userMapper.updateUserByEmId(user);
    }

    /*删除员工*/
    @Transactional
    @Override
    public Integer deleteUserById(String tUserId) {
        return userMapper.deleteUserById(tUserId);
    }

    /*查询员工详情*/
    @Override
    public UserEntity selectUserByIds(String tUserId) {
        return userMapper.selectUserByIds(tUserId);
    }

    /*按照姓名或部门搜索*/
    @Override
    public PageInfo<UserDept> selectUserByNameDeptName(String name, String deptName, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<UserDept> sysEmployeeList = userMapper.selectUserByNameDeptName(name,deptName,pageNum,pageSize);
        PageInfo<UserDept> userlistInfo=new PageInfo<>(sysEmployeeList,5);
        return userlistInfo;
    }

    /*查询所有员工 分页*/
    @Override
    public PageInfo<UserEntity> selectUserLists(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<UserEntity> userlist=userMapper.selectUserLists();
        PageInfo<UserEntity> userlistInfo=new PageInfo<>(userlist,5);
        return userlistInfo;
    }

    /*账号密码查询用户*/
    @Override
    public UserEntity selectUserByUsernameAndPassword(String username, String password) {
        return userMapper.selectUserByUsernameAndPassword(username,password);
    }

    @Override
    public List<UserEntity> selectUserImg(UserEntity user) {
        return null;
    }

    /*查询所有员工 图片*/
    @Override
    public  List<UserEntity> selectUserImg() {
        return userMapper.selectUserImg();
    }

    /*查询角色id*/
    @Override
    public String selectRoleId(String tUserId) {
        return userMapper.selectRoleId(tUserId);
    }

    /*查询所有用户并向首字母属性赋值*/
    @Override
    public List<UserDto> selectAllUserDto() {
        List<UserDto> userDtos=userMapper.selectAllUserDto();
        for(UserDto users:userDtos){
            users.setFirstUpperCase(users.getName().substring(0,1));
        }
        return userDtos;
    }

    /*查询共享文件数量*/
    @Override
    public Integer selectSharedFileCount() {
        return userMapper.selectSharedFileCount();
    }

    /*查询我的上传数量*/
    @Override
    public Integer selectUploadCount(String tUserId) {
        return userMapper.selectUploadCount(tUserId);
    }

    /*查询近期删除数量*/
    @Override
    public Integer selectDeleteCount(String tUserId) {
        return userMapper.selectDeleteCount(tUserId);
    }

    @Override
    public Map<String,UserEntity> selectAllUserList() {
        return userMapper.selectAllUserList();
    }
}
