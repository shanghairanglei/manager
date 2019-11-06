package com.rl.service.impl;


import com.rl.mapper.personmapper.PersonalMapper;
import com.rl.model.Education;
import com.rl.service.PersonalService;
import com.rl.vo.EduProHobbyVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonalServiceImpl implements PersonalService {
    @Autowired
    private PersonalMapper personalMapper;

    //上传用户头像
    @Override
    @Transactional
    public Integer UploadImg(String tUserId, String realPath) {
        return personalMapper.UploadImg(tUserId,realPath);
    }

    //修改密码
    @Override
    @Transactional
    public Integer UpdatePassWord(String tUserId, String password, String newPassword, String conPassword) {
        return personalMapper.UpdatePassWord(tUserId,password,newPassword,conPassword);
    }

    /*查询用户其他信息*/
    @Override
    public List<EduProHobbyVo> selectPersonal(String tUserId) {
        return personalMapper.selectPersonal(tUserId);
    }

    /*查询兴趣*/
    @Override
    public List<EduProHobbyVo> selectHobby(String tUserId) {
        return personalMapper.selectHobby(tUserId);
    }

    //查询工作经历
    @Override
    public List<EduProHobbyVo> selectExperience(String tUserId) {
        return personalMapper.selectExperience(tUserId);
    }

    //修改个人简介
    @Transactional
    @Override
    public Integer UpdateProfile(String tUserId,String newDescription) {
        return personalMapper.UpdateProfile(tUserId,newDescription);
    }

    //修改教育信息
    @Transactional
    @Override
    public Integer updateEducation(EduProHobbyVo eduProHobbyVo) {
        return personalMapper.updateEducation(eduProHobbyVo);
    }

    /*查询教育详情*/
    @Override
    public EduProHobbyVo selectEducation(String tUserId) {
        return personalMapper.selectEducation(tUserId);
    }

    //查询工作经历
    @Override
    public EduProHobbyVo selectExperiences(String tUserId) {
        return personalMapper.selectExperiences(tUserId);
    }

    //修改工作经历
    @Override
    @Transactional
    public Integer updateExperience(EduProHobbyVo eduProHobbyVo) {
        return personalMapper.updateExperience(eduProHobbyVo);
    }

    //添加工作经历
    @Override
    @Transactional
    public Integer InsertExperience(EduProHobbyVo eduProHobbyVo) {
        return personalMapper.InsertExperience(eduProHobbyVo);
    }

    //添加教育信息
    @Override
    @Transactional
    public Integer InsertEducation(EduProHobbyVo eduProHobbyVo) {
        return personalMapper.InsertEducation(eduProHobbyVo);
    }

    //查询项目
    @Override
    public EduProHobbyVo selectProject(String tUserId) {
        return personalMapper.selectProject(tUserId);
    }

    //修改项目
    @Override
    @Transactional
    public Integer updateProject(EduProHobbyVo eduProHobbyVo) {
        return personalMapper.updateProject(eduProHobbyVo);
    }

    //添加项目
    @Override
    @Transactional
    public Integer InsertProject(EduProHobbyVo eduProHobbyVo) {
        return personalMapper.InsertProject(eduProHobbyVo);
    }
}
