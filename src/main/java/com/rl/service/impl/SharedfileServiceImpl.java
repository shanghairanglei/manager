package com.rl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rl.mapper.sharedfilemapper.SharedfileMapper;
import com.rl.model.ActionRecord;
import com.rl.model.Fileupload;
import com.rl.model.User;
import com.rl.service.SharedfileService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author lzw
 * @date 2019/8/27 9:36
 */
@Service("SharedfileService")
public class SharedfileServiceImpl implements SharedfileService {
    @Autowired
    private SharedfileMapper sharedfileMapper;

    /*查询所有文件 分页*/
    @Override
    public PageInfo<Fileupload> selectsharedFileList(Integer pageNum, Integer pageSize,String tUserId,String fileName) {
        PageHelper.startPage(pageNum,pageSize);
        List<Fileupload> filelist=sharedfileMapper.selectsharedFileList(tUserId,fileName);
        PageInfo<Fileupload> filelistInfo=new PageInfo<>(filelist);
        return filelistInfo;
    }

    //删除文件
    @Override
    public Integer deleteFileByFileId(Integer fileId) {
        return sharedfileMapper.deleteFileByFileId(fileId);
    }

    /*删除文件后添加该文件的操作记录*/
    @Override
    public Integer addActionRecord(ActionRecord actionRecord) {
        actionRecord.setActionTime(new Date());
        Subject subject = SecurityUtils.getSubject();
        //获取当前登陆的用户主体
        User user = (User)subject.getPrincipal();
        actionRecord.setActionName(user.getName());
        return sharedfileMapper.addActionRecord(actionRecord);
    }

    //操作记录
    @Override
    public ActionRecord selectFileRecordList(Integer fileId) {
        return sharedfileMapper.selectFileRecordList(fileId);
    }

    /*根据员工姓名查询tUserId*/
    @Override
    public String selecttUserIdByName(String name) {
        return sharedfileMapper.selecttUserIdByName(name);
    }
}
