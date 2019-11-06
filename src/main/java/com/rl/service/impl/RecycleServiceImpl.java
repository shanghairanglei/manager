package com.rl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rl.mapper.recyclemapper.RecyleMapper;
import com.rl.model.ActionRecord;
import com.rl.model.Fileupload;
import com.rl.service.RecycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("/RecycleService")
public class RecycleServiceImpl implements RecycleService {

    @Autowired
    private RecyleMapper recyleMapper;

    /*回收站查询文件列表*/
    @Override
    public List<Fileupload> selectRecycleFile() {
        return recyleMapper.selectRecycleFile();
    }

    /*回收站查询文件列表分页*/
    @Override
    public PageInfo<Fileupload> selectRecycleFileList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Fileupload> fileList=recyleMapper.selectRecycleFileList();
        PageInfo<Fileupload> fileInfo=new PageInfo<>(fileList);
        return fileInfo;
    }

    /*回收站删除文件*/
    @Override
    public Integer deleteFileByFileId(Integer fileId) {
        return recyleMapper.deleteFileByFileId(fileId);
    }

    /*删除文件对应的操作记录*/
    @Override
    public Integer deleteActionRecord(Integer fileId) {
        return recyleMapper.deleteActionRecord(fileId);
    }

    /*回收站恢复文件*/
    @Override
    public Integer recoverFileByFileId(Integer fileId) {
        return recyleMapper.recoverFileByFileId(fileId);
    }

    /*查看文件操作记录*/
    @Override
    public List<ActionRecord> selectFileRecordList(Integer fileId) {
        return recyleMapper.selectFileRecordList(fileId);
    }

    /*根据文件名搜索*/
    @Override
    public List<Fileupload> selectFileByfileName(String fileName) {
        return recyleMapper.selectFileByfileName(fileName);
    }
}
