package com.rl.controller.recylecontroller;

import com.github.pagehelper.PageInfo;
import com.rl.model.ActionRecord;
import com.rl.model.Fileupload;
import com.rl.service.PersonalFileService;
import com.rl.service.RecycleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @ClassName
 * @Description 回收站
 * @Author
 * @Date 2019/8/14 13:53
 * @Version 1.0
 **/
@Controller
@RequestMapping("/recycle")
public class RecycleController {
    @Autowired
    private RecycleService recycleService;
    @Autowired
    private PersonalFileService personalFileService;

    /**
     * 回收站
     *
     * @return
     */
    @RequestMapping("/go")
    public String myRecycle() {
        return "recycle";
    }

    /**
     * lzw
     * 回收站查询文件列表
     * @param model
     * @return
     */
    @RequestMapping("/selectRecycleFile")
    @ResponseBody
    public String selectRecycleFile(Model model) {
        List<Fileupload> filelist=recycleService.selectRecycleFile();
        model.addAttribute("filelists",filelist);
        return "recycle";
    }

    /**
     * @Author xfx
     * @Date 14:08 2019/8/14
     * @Param []
     * 回收站查询文件列表 分页
     **/
    @RequestMapping("/recycle")
    @ResponseBody
    public PageInfo<Fileupload> selectRecycleFileList(Integer pageNum, Integer pageSize){
        return recycleService.selectRecycleFileList(pageNum, pageSize);
    }

    /**
     * @Author xfx
     * @Date 14:09 2019/8/14
     * @Param
     * 1 回收站删除文件 2删除文件后并删除对应的操作记录
     **/
    @RequestMapping("/deleteFileByFileId")
    @ResponseBody
    public Integer deleteFileByFileId(Integer fileId){
        Integer result=recycleService.deleteFileByFileId(fileId);
        /*删除文件后并删除对应的操作记录*/
        Integer deleteRecord=recycleService.deleteActionRecord(fileId);
        return result+deleteRecord;
    }

    /**
     * @Author xfx
     * @Date 14:09 2019/8/14
     * @Param
     * 回收站恢复文件,添加该文件的操作记录
     **/
    @ResponseBody
    @RequestMapping("/recoverFileByFileId")
    public Integer recoverFileByFileId(Integer fileId){
        Integer result=recycleService.recoverFileByFileId(fileId);
        /*添加该文件的操作记录*/
        ActionRecord actionRecord=new ActionRecord();
        actionRecord.setFileId(fileId);
        actionRecord.setActionKinds(3);
        Integer addResult=personalFileService.addActionRecord(actionRecord);
        return result+addResult;
    }
    /**
     * @Author xfx
     * @Date 14:20 2019/8/14
     * @Param
     * 查看文件操作记录
     **/
    @RequestMapping("/selectFileRecordList")
    @ResponseBody
    public List<ActionRecord> selectFileRecordList(Integer fileId){
          return recycleService.selectFileRecordList(fileId);
    }

    /**
     * @Author lzw
     * 回收站(根据文件名搜索)
     */
    @ResponseBody
    @RequestMapping("/selectFileByfileName")
    public List<Fileupload> selectFileByfileName(@Param(value ="fileName")String fileName) {
        List<Fileupload> FileuploadList=recycleService.selectFileByfileName(fileName);
        return FileuploadList;
    }

}
