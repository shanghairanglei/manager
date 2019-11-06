package com.rl.service;

import com.github.pagehelper.PageInfo;
import com.rl.model.ActionRecord;
import com.rl.model.Fileupload;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


@Service
public interface PersonalFileService {

    /*我的上传文件列表*/
    PageInfo<Fileupload> selectFileListByemId(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("emId") Integer emId);

    /*删除文件*/
    Integer deleteFileByFileId(@Param("file_id") Integer fileId);

    /*删除文件后添加该文件的操作记录*/
    Integer addActionRecord(ActionRecord actionRecord);

    

}
