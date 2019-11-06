package com.rl.controller.personalfilecontroller;

import com.github.pagehelper.PageInfo;
import com.rl.model.ActionRecord;
import com.rl.model.Fileupload;
import com.rl.service.PersonalFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @ClassName
 * @Description 我的上传
 * @Author xfx
 * @Date 2019/8/14 9:03
 **/
@Controller
@RequestMapping("/personalfile")
public class PersonalFileController {

    @Autowired
    private PersonalFileService personalFileService;
    /**
     * @Author xfx
     * @Date 10:26 2019/8/14
     * @Param [emId]
     * 我的上传文件列表查询
     **/

    @RequestMapping("/selectFileListByemId")
    @ResponseBody
    public PageInfo<Fileupload> selectFileListByemId(Integer pageNum, Integer pageSize, Integer emId){
        return personalFileService.selectFileListByemId(pageNum, pageSize, emId);
    }
    /**
     * @Author xfx
     * @Date 10:36 2019/8/14
     * @Param
     * 删除文件,1 将文件状态设置为回收站状态,2 向操作记录表添加一条记录
     **/
    @RequestMapping("/deleteFileByFileId")
    @ResponseBody
    public  Integer deleteFileByFileId(Integer fileId){
        Integer result=personalFileService.deleteFileByFileId(fileId);
        ActionRecord actionRecord=new ActionRecord();
        actionRecord.setFileId(fileId);
        actionRecord.setActionKinds(0);
        Integer addResult=personalFileService.addActionRecord(actionRecord);
        return result+addResult;
    }
}
