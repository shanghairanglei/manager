package com.rl.controller.workplancontroller;

import com.rl.dto.UserDto;
import com.rl.model.UserEntity;
import com.rl.model.Workplans;
import com.rl.service.UserService;
import com.rl.service.WorkplansService;
import com.rl.utils.GlobleService;
import com.rl.utils.ImageBase64Utils;
import com.rl.vo.UserWorkPlans;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/workplan")
public class WorkPlanController {

    @Autowired
    private WorkplansService workplansService;
    @Autowired
    private UserService userService;
    @RequestMapping("/go")
    public String go(@Param("deptId") HttpServletRequest request,Model model){
        UserEntity user =  (UserEntity)request.getSession().getAttribute("user");
        List<UserDto> userList=userService.selectAllUserDto();
        //查询所有img对应的路径
        for(UserDto u:userList){
            String path=u.getImg();
            String imgstr= ImageBase64Utils.imageToBase64(path);
            u.setImg("data:image/jpeg;base64,"+imgstr);
        }
        model.addAttribute("userList",userList);
        return "workday";
    }

    /**
     * 搜索工作计划
     * @param file_createDate1 日期1
     * @param file_createDate2 日期2
     * @param deptId 部门id
     * @return
     */
    @RequestMapping("/findByDateDept")
    public  String findByDateDept(Model model,Integer deptId,String file_createDate1,String file_createDate2){
        List<Workplans> workplansList = workplansService.findByDateDept(deptId,file_createDate1,file_createDate2);
        model.addAttribute("workplansList",workplansList);
        List<UserDto> userList=userService.selectAllUserDto();
        //查询所有img对应的路径
        for(UserDto u:userList){
            String path=u.getImg();
            String imgstr= ImageBase64Utils.imageToBase64(path);
            u.setImg("data:image/jpeg;base64,"+imgstr);
        }
        model.addAttribute("userList",userList);
        return "workday";
    }

    /**
     * 写工作计划
     * @param workPlanList
     * @return
     */
    @RequestMapping("/wirteWork")
    @ResponseBody
    public Map<String,Object> wirteWork( HttpServletRequest request,@RequestBody List<UserWorkPlans> workPlanList){
        Map<String,Object> map = new HashMap<>();
        UserEntity user = (UserEntity) request.getSession().getAttribute("user");
        for (UserWorkPlans workPlans :workPlanList ) {
            workPlans.setWpName(workPlans.getWpName()+ GlobleService.getDateString(new Date()));
            workPlans.settUserId(user.gettUserId());
            workPlans.setWpCreatedate(new Date());
            //提交为审核中工作计划
            workPlans.setWpStatus(0);
            //不是工作总结
            workPlans.setIfSummary(0);
            if(workPlans.getWpRemark() == null){
                workPlans.setWpRemark("");
            }
            Integer result = workplansService.insertWork(workPlans);
            map.put("result",result);
        }
        return map;
    }

}
