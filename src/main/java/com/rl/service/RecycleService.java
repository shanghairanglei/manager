package com.rl.service;

import com.github.pagehelper.PageInfo;
import com.rl.model.ActionRecord;
import com.rl.model.Fileupload;
import com.rl.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecycleService {

    /*查询所有文件列表*/
    List<Fileupload> selectRecycleFile();

    /*回收站查询文件列表分页*/
    PageInfo<Fileupload> selectRecycleFileList(Integer pageNum, Integer pageSize);

    /*回收站删除文件*/
    Integer deleteFileByFileId(Integer fileId);

    /*删除文件对应的操作记录*/
    Integer deleteActionRecord(Integer fileId);

    /*回收站恢复文件*/
    Integer recoverFileByFileId(Integer fileId);

    /*查看文件操作记录*/
    List<ActionRecord> selectFileRecordList(Integer fileId);

    /*按照文件名搜索*/
    List<Fileupload> selectFileByfileName(String fileName);
}
