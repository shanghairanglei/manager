package com.rl.service;

import com.github.pagehelper.PageInfo;
import com.rl.dto.UserDto;
import com.rl.model.User;
import com.rl.model.UserEntity;
import com.rl.vo.EduProHobbyVo;
import com.rl.vo.UserDept;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {

    int insert(User record);

    int insertSelective(User record);

    User selectByNamePwd(@Param("username") String username, @Param("password") String password);

    User selectByName(@Param("username")String username);

    User selectUserById(@Param("id") int id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /*查询所有人员列表*/
    List<UserEntity> selectUserList();

    /*添加员工*/
    Integer addUser(UserEntity user);
    /*级联添加员工角色*/
    Integer addUserRole(@Param("tUserId") String tUserId,@Param("roleId") String roleId);

    /*修改员工基本信息*/
    Integer updateUserByEmId(UserEntity user);

    /*删除员工*/
    Integer deleteUserById(String tUserId);

    /*查询员工详情*/
    UserEntity selectUserByIds(String tUserId);

    /*按照姓名或部门搜索*/
    PageInfo<UserDept> selectUserByNameDeptName(@Param("name") String name, @Param("deptName") String deptName, Integer pageNum, Integer pageSize);

    /*查询所有员工 分页*/
    PageInfo<UserEntity> selectUserLists(Integer pageNum, Integer pageSize);

    /*账号密码查询用户*/
    UserEntity selectUserByUsernameAndPassword(String username, String password);

    /*查询用户头像*/
    List<UserEntity> selectUserImg(UserEntity user);

    /*查询共享文件数量*/
    Integer selectSharedFileCount();

    /*查询我的上传数量*/
    Integer selectUploadCount (String tUserId);

    /*查询近期删除数量*/
    Integer selectDeleteCount(String tUserId);

    /*人员列表查询*/
    Map<String,UserEntity> selectAllUserList();

    /*查询角色id*/
    String selectRoleId(String tUserId);

    /*查询所有用户并向首字母属性赋值*/
    List<UserDto>  selectAllUserDto();

    /*查询所有员工 图片*/
    List<UserEntity> selectUserImg();

}
