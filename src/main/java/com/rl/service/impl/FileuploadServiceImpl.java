package com.rl.service.impl;

import com.rl.mapper.FileuploadMapper;
import com.rl.model.Fileupload;
import com.rl.service.FileuploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;
import java.util.List;
@Service
public class FileuploadServiceImpl implements FileuploadService {
    @Autowired
    private FileuploadMapper fileuploadMapper;

    @Override
    public int deleteByPrimaryKey(Integer fileId) {
        return 0;
    }

    @Override
    public int insert(Fileupload record) {
        return 0;
    }

    @Override
    public int insertSelective(Fileupload record) {
        return 0;
    }

    @Override
    public Fileupload selectByPrimaryKey(Integer fileId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Fileupload record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Fileupload record) {
        return 0;
    }

    @Override
    public List<File> findFileByTitleDate(String file_name, Date file_createDate1,Date file_createDate2) {
        return fileuploadMapper.findFileByTitleDate(file_name,file_createDate1,file_createDate2);
    }
}
