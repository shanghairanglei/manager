package com.rl.mapper.personalfilemapper;

import com.rl.model.ActionRecord;
import com.rl.model.Fileupload;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface PersonalFileMapper {
    //我的上传文件列表
    List<Fileupload> selectFileListByemId(@Param("emId") Integer emId);

    //删除文件
    Integer deleteFileByFileId(@Param("file_id") Integer fileId);

    //删除文件后添加该文件的操作记录
    Integer addActionRecord(ActionRecord actionRecord);
}
