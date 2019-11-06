package com.rl.service;

import com.rl.vo.EduProHobbyVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonalService {
    /*上传用户头像*/
    Integer UploadImg(@Param(value ="tUserId")String tUserId,@Param(value ="realPath")String realPath);

    /*修改用户密码*/
    Integer UpdatePassWord(@Param(value ="tUserId")String tUserId, @Param(value ="password")String password, @Param(value ="newPassword")String newPassword, @Param(value ="newPassword")String conPassword);

    /*查询用户其他信息*/
    List<EduProHobbyVo> selectPersonal(@Param(value ="tUserId")String tUserId);

    /*查询兴趣*/
    List<EduProHobbyVo> selectHobby(@Param(value ="tUserId")String tUserId);

    /*查询工作经历*/
    List<EduProHobbyVo> selectExperience(@Param(value ="tUserId")String tUserId);

    //修改个人简介
    Integer UpdateProfile(@Param(value ="tUserId")String tUserId,@Param(value ="newDescription")String newDescription);

    /*修改教育信息*/
    Integer updateEducation(EduProHobbyVo eduProHobbyVo);

    /*查询教育详情*/
    EduProHobbyVo selectEducation(String tUserId);

    /*查询工作经历*/
    EduProHobbyVo selectExperiences(@Param(value ="tUserId")String tUserId);

    //修改工作经历
    Integer updateExperience(EduProHobbyVo eduProHobbyVo);

    //新增工作经历
    Integer InsertExperience(EduProHobbyVo eduProHobbyVo);

    /*新增教育信息*/
    Integer InsertEducation(EduProHobbyVo eduProHobbyVo);

    /*查询项目详情*/
    EduProHobbyVo selectProject(String tUserId);

    //修改项目经历
    Integer updateProject(EduProHobbyVo eduProHobbyVo);

    //新增项目经历
    Integer InsertProject(EduProHobbyVo eduProHobbyVo);
}
