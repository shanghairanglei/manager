package com.rl.mapper.recyclemapper;

import com.rl.model.ActionRecord;
import com.rl.model.Fileupload;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RecyleMapper {
    /*查询所有文件列表*/
    List<Fileupload> selectRecycleFile();

    /*回收站查询文件列表*/
    List<Fileupload> selectRecycleFileList();

    /*回收站删除文件*/
    Integer deleteFileByFileId(Integer fileId);

    /*删除文件对应的操作记录*/
    Integer deleteActionRecord(Integer fileId);

    /*回收站恢复文件*/
    Integer recoverFileByFileId(Integer fileId);

    /*恢复文件添加对应的操作记录*/
    Integer recoverFileRecord(ActionRecord rlActionRecord);

    /*查看文件操作记录*/
    List<ActionRecord> selectFileRecordList(Integer fileId);

    /*按照姓文件名搜索*/
    List<Fileupload> selectFileByfileName(@Param(value ="fileName")String fileName);
}
