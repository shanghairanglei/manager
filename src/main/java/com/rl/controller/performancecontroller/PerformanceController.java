package com.rl.controller.performancecontroller;

import com.github.pagehelper.PageInfo;
import com.rl.dto.PerformanceDto;
import com.rl.dto.UserDto;
import com.rl.model.UserEntity;
import com.rl.model.Workplans;
import com.rl.service.PerformanceService;
import com.rl.service.UserService;
import com.rl.utils.CalendarUtils;
import com.rl.utils.ImageBase64Utils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;
/**
 * @Author xfx
 * @Date 9:12 2019/9/2
 * @Param
 * @return
 * 绩效统计
 **/

@Controller
@RequestMapping("/performance")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;
    @Autowired
    private UserService userService;

    /* 员工绩效查询*/
    @ResponseBody
    @RequestMapping("/performance")
    public PageInfo<Workplans> selectPerformanceList(Integer pageNum, Integer pageSize, String tUserId){
       //查询所属部门名称
        //String deptName=performanceService.selectDepetName(tUserId);
        return performanceService.selectPerformanceList(pageNum,pageSize,tUserId);
    }

    /*个人绩效*/
    @RequestMapping("/personalCenter")
    public String personalCenter(@Param(value = "tUserId") String tUserId,Model model,HttpSession session){
        List<UserDto> userList=userService.selectAllUserDto();
        //查询所有img对应的路径
        for(UserDto u:userList){
            String path=u.getImg();
            String imgstr= ImageBase64Utils.imageToBase64(path);
            u.setImg("data:image/jpeg;base64,"+imgstr);
        }
        //查询个人绩效，默认查询最近一月
        List<Workplans> workplansList=performanceService.selectWorkPlansBytUserId(tUserId,new CalendarUtils().getSimpleDateFormat(-30).toString(),new CalendarUtils().getSimpleDateFormat(-1).toString());
        //查询工作计划条数
        Integer sumplans=performanceService.getWorkPlansSum(tUserId,new CalendarUtils().getSimpleDateFormat(-30).toString(),new CalendarUtils().getSimpleDateFormat(-1).toString());
        model.addAttribute("sumplans","累 计："+sumplans+"条工作计划");
        model.addAttribute("userList",userList);
        model.addAttribute("tUserId",tUserId);
        model.addAttribute("deptId",session.getAttribute("deptId"));
        model.addAttribute("user",session.getAttribute("user"));
       return "check";
    }

    /*个人绩效查询，员工身份进入*/
    @ResponseBody
    @RequestMapping("/selectPersonPerformance")
    public Map<String,Object> selectPerformance(HttpServletRequest request){
        String tUserId=request.getParameter("tUserId");
        Integer v=Integer.parseInt(request.getParameter("v"));
        Map<String,Object> map=new HashMap<>();
        //查询所属部门名称
        String deptName=performanceService.selectDepetName(tUserId);
        //查询个人绩效，默认查询最近一周
        List<Workplans> workplansList=performanceService.selectWorkPlansBytUserId(tUserId,new CalendarUtils().getSimpleDateFormat(v),new CalendarUtils().getSimpleDateFormat(-1));
        Integer wpProspectPerformance=workplansList.stream().collect(Collectors.summingInt(Workplans::getWpProspectPerformance));
        Integer wpActualPerformance=workplansList.stream().collect(Collectors.summingInt(Workplans::getWpActualPerformance));
        //查询图片
        UserEntity userEntity= userService.selectUserByIds(tUserId);
        String path=userEntity.getImg();
        String imgstr= ImageBase64Utils.imageToBase64(path);

        //查询工作计划条数
        Integer sumplans=performanceService.getWorkPlansSum(tUserId,new CalendarUtils().getSimpleDateFormat(v),new CalendarUtils().getSimpleDateFormat(-1));
        map.put("sumplans","累 计："+sumplans+"条工作计划");
        map.put("imgstr",imgstr);
        map.put("deptName",deptName);
        map.put("wpProspectPerformance",wpProspectPerformance);
        map.put("wpActualPerformance",wpActualPerformance);
        return map;
    }
    /*个人绩效查询，人事身份进入*/
    @ResponseBody
    @RequestMapping("/selectPerformanceList")
    public Map<String,Object> selectPerformanceList(Integer v){
        List<UserEntity> userList=userService.selectUserList();
        Map<String,Object> map=new HashMap<>();
        //查询个人绩效，默认查询最近一月
        v=-30;
        List<Workplans> workplansList=performanceService.selectWorkPlansBytUserId(userList.get(0).gettUserId(),new CalendarUtils().getSimpleDateFormat(v).toString(),new CalendarUtils().getSimpleDateFormat(-1).toString());
        Integer wpProspectPerformance=workplansList.stream().collect(Collectors.summingInt(Workplans::getWpProspectPerformance));
        Integer wpActualPerformance=workplansList.stream().collect(Collectors.summingInt(Workplans::getWpActualPerformance));
        Integer checkPerformance=workplansList.stream().collect(Collectors.summingInt(Workplans::getCheckPoint));
        map.put("userList",userList);
        map.put("wpProspectPerformance",wpProspectPerformance);
        map.put("wpActualPerformance",wpActualPerformance);
        map.put("checkPerformance",checkPerformance);
        return map;
    }

    /*个人绩效查询,boss身份进入*/
    @ResponseBody
    @RequestMapping("/selectAllPerformanceList")
    public Map<String,Object> selectAllPerformanceList(Integer v){
        List<UserEntity> userList=userService.selectUserList();
        Map<String,Object> map=new HashMap<>();
        //查询个人绩效，默认查询最近一周
        List<Workplans> workplansList=performanceService.selectWorkPlansBytUserId(userList.get(0).gettUserId(),new CalendarUtils().getSimpleDateFormat(v).toString(),new CalendarUtils().getSimpleDateFormat(-1).toString());
        Integer wpProspectPerformance=workplansList.stream().collect(Collectors.summingInt(Workplans::getWpProspectPerformance));
        Integer wpActualPerformance=workplansList.stream().collect(Collectors.summingInt(Workplans::getWpActualPerformance));
        map.put("userList",userList);
        map.put("wpProspectPerformance",wpProspectPerformance);
        map.put("wpActualPerformance",wpActualPerformance);
        return map;
    }


    /**
     * @Author xfx
     * @Date 19:47 2019/9/15
     * @Param [name]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     *  通过姓名查询用户
     **/
    @ResponseBody
    @RequestMapping("/searchUserByName")
    public Map<String,Object> searchUserByName(HttpServletRequest request,Model model){
        String name=request.getParameter("name");
        Map<String,Object> map=new HashMap<String, Object>();
        UserDto  userDto=performanceService.searchUserByName(name);
        if(userDto!=null){
            userDto.setFirstUpperCase(userDto.getName().substring(0,1));
        }
        map.put("user",userDto);
        return map;
    }

    /**
     * @Author xfx
     * @Date 16:25 2019/9/23
     * @Param [tUserId, v, request, model, session]
     * @return java.lang.String
     * 人事点击月/年/周查看绩效
     **/
    @ResponseBody
    @RequestMapping("/getUserPer")
    public Map<String,Object> getUserPer(@Param(value = "tUserId") String tUserId,Integer v,Integer total,HttpServletRequest request, Model model, HttpSession session){
        Map<String,Object> map=new HashMap<String, Object>();
        Integer []actualStr=new Integer[10];
        Integer []expectStr=new Integer[10];
        Integer []checkStr=new Integer[10];
        if(v==-7){
            String []timeStr=new String[]{"第一天","第二天","第三天","第四天","第五天","第六天","第七天"};
            List<PerformanceDto> performanceDtoList=performanceService.selectUserDetailPerformanceByWeek(tUserId,new CalendarUtils().getSimpleDateFormat(v).toString(),new CalendarUtils().getSimpleDateFormat(-1).toString(),total);
            for(int i=0;i<performanceDtoList.size();i++) {
                actualStr[i] = performanceDtoList.get(i).getActualCountPerformance();
                expectStr[i] = performanceDtoList.get(i).getProspectCount();
                checkStr[i] = performanceDtoList.get(i).getCheckPointCount();
                map.put("actualStr", actualStr);
                map.put("expectStr", expectStr);
                map.put("checkStr", checkStr);
                map.put("timeStr", timeStr);
            }
          }
           if (v==-30){
                String []timeStr=new String[]{"第一周","第二周","第三周","第四周","第五周"};
                List<PerformanceDto> performanceDtoList=performanceService.selectUserDetailPerformance(tUserId,new CalendarUtils().getSimpleDateFormat(v).toString(),new CalendarUtils().getSimpleDateFormat(-1).toString(),total);
                for(int i=0;i<performanceDtoList.size();i++) {
                    actualStr[i] = performanceDtoList.get(i).getActualCountPerformance();
                    expectStr[i] = performanceDtoList.get(i).getProspectCount();
                    checkStr[i] = performanceDtoList.get(i).getCheckPointCount();
                    map.put("actualStr", actualStr);
                    map.put("expectStr", expectStr);
                    map.put("checkStr", checkStr);
                    map.put("timeStr", timeStr);
                }
            }
            if(v==-365){
                String []timeStr=new String[]{"一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"};
                List<PerformanceDto> performanceDtoList=performanceService.selectUserDetailPerformanceByYear(tUserId,new CalendarUtils().getSimpleDateFormat(v).toString(),new CalendarUtils().getSimpleDateFormat(-1).toString(),total);
                for(int i=0;i<performanceDtoList.size();i++) {
                    actualStr[i] = performanceDtoList.get(i).getActualCountPerformance();
                    expectStr[i] = performanceDtoList.get(i).getProspectCount();
                    checkStr[i] = performanceDtoList.get(i).getCheckPointCount();
                    map.put("actualStr", actualStr);
                    map.put("expectStr", expectStr);
                    map.put("checkStr", checkStr);
                    map.put("timeStr", timeStr);
                }
            }
        return map;
    }


    /**
     * @Author xfx
     * @Date 17:07 2019/9/25
     * @Param [tUserId, v]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     *领导身份年/月/周查看绩效
     **/
    @ResponseBody
    @RequestMapping("/getUserPerBoss")
   public Map<String,Object> getUserPerBoss(@Param(value = "tUserId") String tUserId,Integer v){
        Map<String,Object> map=new HashMap<String ,Object>();
        List<Workplans> workplansList=performanceService.selectWorkPlansBytUserId(tUserId,new CalendarUtils().getSimpleDateFormat(v).toString(),new CalendarUtils().getSimpleDateFormat(-1).toString());
        map.put("workplansList",workplansList);
        UserEntity user=userService.selectUserByIds(tUserId);
        //自测绩效点之和
        Integer wpProspectPerformance=workplansList.stream().collect(Collectors.summingInt(Workplans::getWpProspectPerformance));
        //实际绩效点之和
        Integer wpActualPerformance=workplansList.stream().collect(Collectors.summingInt(Workplans::getWpActualPerformance));
        //审核绩效点之和
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        String result = numberFormat.format((float) wpActualPerformance / (float) wpProspectPerformance * 100);
        result+="%";
        float y_salary=Math.round((float)user.getSalary().floatValue()*12/252);
        float m_salary=Math.round((float)user.getSalary().floatValue()/22);
        String cost=numberFormat.format(y_salary/m_salary*100);
        cost+="%";

        //查询工作计划条数
        Integer sumplans=performanceService.getWorkPlansSum(tUserId,new CalendarUtils().getSimpleDateFormat(v).toString(),new CalendarUtils().getSimpleDateFormat(-1).toString());
        map.put("sumplans","累 计："+sumplans+"条工作计划");
        map.put("m_salary",m_salary);
        map.put("y_salary",y_salary);
        map.put("firstuser",tUserId);
        map.put("wpProspectPerformance",wpProspectPerformance);
        map.put("wpActualPerformance",wpActualPerformance);
       return map;
    }

    /**
     * @Author xfx
     * @Date 13:16 2019/9/26
     * @Param [tUserId]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * 领导搜索查看绩效
     **/
    @ResponseBody
    @RequestMapping("/getUserPerformanceData")
    public Map<String,Object> getUserPerformanceData(@Param(value = "tUserId") String tUserId){
        Map<String,Object> map=new HashMap<String ,Object>();
        UserEntity user=userService.selectUserByIds(tUserId);
        //查询个人绩效，默认查询最近一月
        List<Workplans> workplansList=performanceService.selectWorkPlansBytUserId(tUserId,new CalendarUtils().getSimpleDateFormat(-30).toString(),new CalendarUtils().getSimpleDateFormat(-1).toString());
        //自测绩效点之和
        Integer wpProspectPerformance=workplansList.stream().collect(Collectors.summingInt(Workplans::getWpProspectPerformance));
        //实际绩效点之和
        Integer wpActualPerformance=workplansList.stream().collect(Collectors.summingInt(Workplans::getWpActualPerformance));
        //审核绩效点之和
        Integer checkPointPerformance=workplansList.stream().collect(Collectors.summingInt(Workplans::getWpActualPerformance));

        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        String result = numberFormat.format((float) wpActualPerformance / (float) wpProspectPerformance * 100);
        result+="%";
        float y_salary=Math.round((float)user.getSalary().floatValue()*12/252);
        float m_salary=Math.round((float)user.getSalary().floatValue()/22);
        String cost=numberFormat.format(y_salary/m_salary*100);
        cost+="%";
        map.put("firstuser",tUserId);
        map.put("m_salary",m_salary);
        map.put("y_salary",y_salary);
        map.put("wpProspectPerformance",wpProspectPerformance);
        map.put("wpActualPerformance",wpActualPerformance);
        map.put("checkPointPerformance",checkPointPerformance);
       return map;
    }

    /**
     * @Author xfx
     * @Date 16:40 2019/9/25
     * @Param [tUserId, model]
     * @return java.lang.String
     * 领导身份查看员工绩效
     **/
    @RequestMapping("/getUserMessageBoss")
    public String getUserMessageBoss(@Param(value = "tUserId") String tUserId,Model model){
        List<UserDto> userList=userService.selectAllUserDto();
        //查询所有img对应的路径
        for(UserDto u:userList){
            String path=u.getImg();
            String imgstr= ImageBase64Utils.imageToBase64(path);
            u.setImg("data:image/jpeg;base64,"+imgstr);
        }
        //查询个人绩效，默认查询最近一月
        List<Workplans> workplansList=performanceService.selectWorkPlansBytUserId(tUserId,new CalendarUtils().getSimpleDateFormat(-30).toString(),new CalendarUtils().getSimpleDateFormat(-1).toString());
        model.addAttribute("workplansList",workplansList);
        model.addAttribute("userList",userList);

        //查询工作计划条数
        Integer sumplans=performanceService.getWorkPlansSum(tUserId,new CalendarUtils().getSimpleDateFormat(-30).toString(),new CalendarUtils().getSimpleDateFormat(-1).toString());
        model.addAttribute("sumplans","累 计："+sumplans+"条工作计划");

        //自测绩效点之和
        Integer wpProspectPerformance=workplansList.stream().collect(Collectors.summingInt(Workplans::getWpProspectPerformance));
        //实际绩效点之和
        Integer wpActualPerformance=workplansList.stream().collect(Collectors.summingInt(Workplans::getWpActualPerformance));
        //审核绩效点之和
        Integer checkPointPerformance=workplansList.stream().collect(Collectors.summingInt(Workplans::getWpActualPerformance));

        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        String result = numberFormat.format((float) wpActualPerformance / (float) wpProspectPerformance * 100);
        result+="%";
        float y_salary=Math.round((float)userList.get(0).getSalary().floatValue()*12/252);
        float m_salary=Math.round((float)userList.get(0).getSalary().floatValue()/22);
        String cost=numberFormat.format(y_salary/m_salary*100);
        cost+="%";
        model.addAttribute("firstuser",tUserId);
        model.addAttribute("wpProspectPerformance",wpProspectPerformance);
        model.addAttribute("wpActualPerformance",wpActualPerformance);
        model.addAttribute("checkPointPerformance",checkPointPerformance);
        model.addAttribute("m_salary",m_salary);
        model.addAttribute("y_salary",y_salary);
        return "boss";
    }

    /**
     * @Author xfx
     * @Date 15:09 2019/9/26
     * @Param [tUserId]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     *  hr搜索查看绩效
     **/
    @ResponseBody
    @RequestMapping("/getUserPerformanceDataHr")
    public Map<String,Object> getUserPerformanceDataHr(@Param(value = "tUserId") String tUserId,Integer v,String roleId,Integer total,HttpSession session){
        Map<String,Object> map=new HashMap<String ,Object>();
        if(v==null){
            v=-30;
            total=5;
        }
        Integer []actualStr=new Integer[10];
        Integer []expectStr=new Integer[10];
        String []timeStr=new String[]{"第一周","第二周","第三周","第四周","第五周"};
        Integer []checkStr=new Integer[10];

        //查询集合中个人绩效，默认查询最近一月
        List<PerformanceDto> performanceDtoList=performanceService.selectUserDetailPerformance(tUserId,new CalendarUtils().getSimpleDateFormat(v).toString(),new CalendarUtils().getSimpleDateFormat(-1).toString(),total);
        for(int i=0;i<performanceDtoList.size();i++){
            actualStr[i]=performanceDtoList.get(i).getActualCountPerformance();
            expectStr[i]=performanceDtoList.get(i).getProspectCount();
            checkStr[i]=performanceDtoList.get(i).getCheckPointCount();
        }
        map.put("firstuser",tUserId);
        map.put("actualStr",actualStr);
        map.put("expectStr",expectStr);
        map.put("timeStr",timeStr);
        map.put("checkStr",checkStr);
        return map;
    }

    /**
     * @Author xfx
     * @Date 15:33 2019/9/23
     * @Param [tUserId, v]
     * @return java.lang.String
     * 查询用户绩效详情
     **/
    @RequestMapping("/getUserDetail")
    public String getUserDetail(@Param(value = "tUserId")String tUserId, Integer v,String roleId, Integer total,HttpServletRequest request, Model model, HttpSession session){
        if(v==null){
            v=-30;
            total=5;
        }
        Integer []actualStr=new Integer[10];
        Integer []expectStr=new Integer[10];
        String []timeStr=new String[]{"第一周","第二周","第三周","第四周","第五周"};
        Integer []checkStr=new Integer[10];
        List<UserDto> userList=userService.selectAllUserDto();
        //查询所有img对应的路径
        for(UserDto u:userList){
            String path=u.getImg();
            String imgstr= ImageBase64Utils.imageToBase64(path);
            u.setImg("data:image/jpeg;base64,"+imgstr);
        }
        //查询集合中个人绩效，默认查询最近一月
        List<PerformanceDto> performanceDtoList=performanceService.selectUserDetailPerformance(tUserId,new CalendarUtils().getSimpleDateFormat(v).toString(),new CalendarUtils().getSimpleDateFormat(-1).toString(),total);
        for(int i=0;i<performanceDtoList.size();i++){
            actualStr[i]=performanceDtoList.get(i).getActualCountPerformance();
            expectStr[i]=performanceDtoList.get(i).getProspectCount();
            checkStr[i]=performanceDtoList.get(i).getCheckPointCount();
        }
        model.addAttribute("firstuser",tUserId);
        model.addAttribute("actualStr",actualStr);
        model.addAttribute("expectStr",expectStr);
        model.addAttribute("timeStr",timeStr);
        model.addAttribute("userList",userList);
        model.addAttribute("checkStr",checkStr);
        return "hr";
    }

    /**
     * @Author xfx
     * @Date 15:33 2019/9/23
     * @Param [tUserId, v]
     * @return java.lang.String
     * 验证当前用户角色
     **/
    @RequestMapping("/checkRole")
    public String checkRole(String tUserId,Integer v,String roleId, Integer total,HttpServletRequest request, Model model, HttpSession session){
        if(v==null){
            v=-30;
            total=5;
        }
        List<UserDto> userList=userService.selectAllUserDto();
        //查询所有img对应的路径
        for(UserDto u:userList){
            String path=u.getImg();
            String imgstr= ImageBase64Utils.imageToBase64(path);
            u.setImg("data:image/jpeg;base64,"+imgstr);
        }
        model.addAttribute("userList",userList);
        UserEntity user=(UserEntity)session.getAttribute("user");
        tUserId=user.gettUserId();
        Integer temp=Integer.parseInt(session.getAttribute("roleId").toString());
        model.addAttribute("tUserId",tUserId);
        model.addAttribute("deptId",session.getAttribute("deptId"));
        model.addAttribute("user",session.getAttribute("user"));
        if(temp==1){
            //查询个人绩效，默认查询最近一月
            List<Workplans> workplansList=performanceService.selectWorkPlansBytUserId(userList.get(0).gettUserId(),new CalendarUtils().getSimpleDateFormat(-30).toString(),new CalendarUtils().getSimpleDateFormat(-1).toString());
            model.addAttribute("userList",userList);
            return "check";
        }else if (temp==2){
            Integer []actualStr=new Integer[10];
            Integer []expectStr=new Integer[10];
            String []timeStr=new String[]{"第一周","第二周","第三周","第四周","第五周"};
            Integer []checkStr=new Integer[10];
            //查询集合中个人绩效，默认查询最近一月
            List<PerformanceDto> performanceDtoList=performanceService.selectUserDetailPerformance(userList.get(0).gettUserId(),new CalendarUtils().getSimpleDateFormat(v).toString(),new CalendarUtils().getSimpleDateFormat(-1).toString(),total);
           for(int i=0;i<performanceDtoList.size();i++){
               actualStr[i]=performanceDtoList.get(i).getActualCountPerformance();
               expectStr[i]=performanceDtoList.get(i).getProspectCount();
               checkStr[i]=performanceDtoList.get(i).getCheckPointCount();
           }
            model.addAttribute("firstuser",userList.get(0).gettUserId());
            model.addAttribute("actualStr",actualStr);
            model.addAttribute("expectStr",expectStr);
            model.addAttribute("timeStr",timeStr);
            model.addAttribute("userList",userList);
            model.addAttribute("checkStr",checkStr);
            return "hr";
        }else if (temp==3||temp==5){
            //查询个人绩效，默认查询最近一月
            List<Workplans> workplansList=performanceService.selectWorkPlansBytUserId(userList.get(0).gettUserId(),new CalendarUtils().getSimpleDateFormat(-30).toString(),new CalendarUtils().getSimpleDateFormat(-1).toString());
            model.addAttribute("workplansList",workplansList);
            model.addAttribute("userList",userList);
            //自测绩效点之和
            Integer wpProspectPerformance=workplansList.stream().collect(Collectors.summingInt(Workplans::getWpProspectPerformance));
            //
            Integer wpActualPerformance=workplansList.stream().collect(Collectors.summingInt(Workplans::getWpActualPerformance));
            //审核绩效点之和
            Integer checkPointPerformance=workplansList.stream().collect(Collectors.summingInt(Workplans::getWpActualPerformance));
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setMaximumFractionDigits(2);
            String result = numberFormat.format((float) wpActualPerformance / (float) wpProspectPerformance * 100);
            result+="%";
            float y_salary=Math.round((float)userList.get(0).getSalary().floatValue()*12/252);
            float m_salary=Math.round((float)userList.get(0).getSalary().floatValue()/22);
            String cost=numberFormat.format(y_salary/m_salary*100);
            cost+="%";
            //查询工作计划条数
            Integer sumplans=performanceService.getWorkPlansSum(userList.get(0).gettUserId(),new CalendarUtils().getSimpleDateFormat(-30).toString(),new CalendarUtils().getSimpleDateFormat(-1).toString());
            model.addAttribute("sumplans","累 计："+sumplans+"条工作计划");
            model.addAttribute("m_salary",m_salary);
            model.addAttribute("y_salary",y_salary);
            model.addAttribute("firstuser",userList.get(0).gettUserId());
            model.addAttribute("wpProspectPerformance",wpProspectPerformance);
            model.addAttribute("wpActualPerformance",wpActualPerformance);
            model.addAttribute("checkPointPerformance",checkPointPerformance);
            return "boss";
        }else if (temp==4){//暂时未有相关角色
            return "boss";
        }else{
            return "boss";
        }
    }
}
