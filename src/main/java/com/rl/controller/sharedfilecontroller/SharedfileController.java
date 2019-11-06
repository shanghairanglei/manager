package com.rl.controller.sharedfilecontroller;

import com.github.pagehelper.PageInfo;
import com.rl.model.ActionRecord;
import com.rl.model.Fileupload;
import com.rl.service.SharedfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lzw
 * @date 2019/8/27 9:41
 */
@Controller
@RequestMapping("/sharedfile")
public class SharedfileController {

    @Autowired
    private SharedfileService sharedfileService;

    /**
     *  查询文件列表,分页
     * @param pageNum
     * @param pageSize
     * @return
     */

    @RequestMapping("/selectsharedFileList")
    @ResponseBody
    public PageInfo<Fileupload> selectsharedFileList(Integer pageNum, Integer pageSize,String name,String fileName) {
        //根据姓名查询tUserId
        String tUserId=sharedfileService.selecttUserIdByName(name);
        return sharedfileService.selectsharedFileList(pageNum,pageSize,tUserId,fileName);
    }

    /**
     * @Param
     * @return
     * 删除文件
     **/
    @ResponseBody
    @RequestMapping("/deleteFileByFileId")
    public Integer deleteFileByFileId(Integer fileId){
        Integer result=sharedfileService.deleteFileByFileId(fileId);
        ActionRecord actionRecord=new ActionRecord();
        actionRecord.setFileId(fileId);
        actionRecord.setActionKinds(0);
        Integer addResult=sharedfileService.addActionRecord(actionRecord);
        return  result+addResult;
    }

    /**
     * @Param
     * @return
     * 操作记录
     **/
    @ResponseBody
    @RequestMapping("/selectFileRecordList")
    public ActionRecord selectFileRecordList(Integer fileId){
        ActionRecord  actionRecord=sharedfileService.selectFileRecordList(fileId);
        return  actionRecord;
    }
}
