package com.rl.controller.ratiocontroller;

import com.github.pagehelper.PageInfo;
import com.rl.model.Workplans;
import com.rl.service.RatioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @ClassName
 * @Description 效率统计
 * @Author
 * @Date 2019/8/14 11:41
 * @Version 1.0
 **/
@Controller
@RequestMapping("/ratio")
public class RatioController {
         @Autowired
         private RatioService ratioService;

         /*查询所有人员绩效,除领导,分页*/
         @RequestMapping("/selectUserRatioList")
         @ResponseBody
         public PageInfo<Workplans> selectUserRatioList(Integer pageNum, Integer pageSize, String name, Integer deptId, Date wpStarttime, Date wpEndtime){
             return ratioService.selectUserRatioList(pageNum,pageSize,name,deptId,wpStarttime,wpEndtime);
         }
}
