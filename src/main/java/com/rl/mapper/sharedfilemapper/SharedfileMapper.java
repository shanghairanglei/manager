package com.rl.mapper.sharedfilemapper;

import com.rl.model.ActionRecord;
import com.rl.model.Fileupload;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lzw
 * @date 2019/8/27 9:35
 */
@Mapper
@Repository
public interface SharedfileMapper {

    /*查询所有文件 分页*/
    List<Fileupload> selectsharedFileList(@Param(value = "tUserId") String tUserId,@Param(value = "fileName") String fileName);

    //删除文件
    Integer deleteFileByFileId(Integer fileId);

    /*删除文件后添加该文件的操作记录*/
    Integer addActionRecord(ActionRecord actionRecord);

    //操作记录
    ActionRecord selectFileRecordList(Integer fileId);

    /*根据员工姓名查询tUserId*/
    String selecttUserIdByName(@Param(value = "name") String name);
}
