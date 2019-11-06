package com.rl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rl.mapper.personalfilemapper.PersonalFileMapper;
import com.rl.model.ActionRecord;
import com.rl.model.Fileupload;
import com.rl.model.User;
import com.rl.service.PersonalFileService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName
 * @Description TODO
 * @Author
 * @Date 2019/8/14 10:23
 * @Version 1.0
 **/
@Service
public class PersonalFileServiceImpl implements PersonalFileService {

    @Autowired
    private PersonalFileMapper personalFileMapper;

    /*我的文件列表查询*/
    @Override
    public PageInfo<Fileupload> selectFileListByemId(Integer pageNum, Integer pageSize, Integer emId) {
        PageHelper.startPage(pageNum,pageSize);
        List<Fileupload> FileuploadList=personalFileMapper.selectFileListByemId(emId);
        PageInfo<Fileupload> filelistInfo=new PageInfo<>(FileuploadList);
        return filelistInfo;
    }

    /*删除文件*/
    @Override
    public Integer deleteFileByFileId(Integer fileId) {
        return personalFileMapper.deleteFileByFileId(fileId);
    }

    /*删除文件后添加该文件的操作记录*/
    @Override
    public Integer addActionRecord(ActionRecord actionRecord) {
        actionRecord.setActionTime(new Date());
        actionRecord.setActionName("token里面拿的");
        return personalFileMapper.addActionRecord(actionRecord);
    }
}
