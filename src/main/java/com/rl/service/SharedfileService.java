package com.rl.service;

import com.github.pagehelper.PageInfo;
import com.rl.model.ActionRecord;
import com.rl.model.Fileupload;
import org.springframework.stereotype.Service;

/**
 * @author lzw
 * @date 2019/8/27 9:36
 */
@Service
public interface SharedfileService {
    /*查询所有文件 分页*/
    PageInfo<Fileupload> selectsharedFileList(Integer pageNum, Integer pageSize,String tUserId,String fileName);

    /*删除文件*/
    Integer deleteFileByFileId(Integer fileId);

    /*删除文件后添加该文件的操作记录*/
    Integer addActionRecord(ActionRecord actionRecord);

    /*操作记录*/
    ActionRecord selectFileRecordList(Integer fileId);

    /*根据员工姓名查询tUserId*/
    String selecttUserIdByName(String name);
}
