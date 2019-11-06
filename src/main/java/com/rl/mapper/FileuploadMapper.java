package com.rl.mapper;

import com.rl.model.Fileupload;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface FileuploadMapper {
    int deleteByPrimaryKey(Integer fileId);

    int insert(Fileupload record);

    int insertSelective(Fileupload record);

    Fileupload selectByPrimaryKey(Integer fileId);

    int updateByPrimaryKeySelective(Fileupload record);

    int updateByPrimaryKey(Fileupload record);

    List<File> findFileByTitleDate(@Param("file_name") String file_name, @Param("file_createDate1") Date file_createDate1, @Param("file_createDate2")Date file_createDate2);

}