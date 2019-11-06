package com.rl.controller.uploadcontroller;

import com.github.pagehelper.PageInfo;
import com.rl.dto.Summary;
import com.rl.dto.UserDto;
import com.rl.model.UserEntity;
import com.rl.service.UserService;
import com.rl.service.WorkplansService;
import com.rl.utils.GlobleService;
import com.rl.utils.ImageBase64Utils;
import com.rl.vo.UserWorkPlans;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private WorkplansService workplansService;

    @Autowired
    private UserService userService;

    /**
     * 计划总结页面
     * @param model
     * @return
     */
    @RequestMapping("/findWork")
    public String findWorkById(Model model,String wpName ,String file_createDate1,String file_createDate2,
                               @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){
            //拼接字符串
            String file_createDate11 = file_createDate1+" 00:00:00";
            String file_createDate22 = file_createDate2+" 23:59:59";
            if(file_createDate1==null || file_createDate1 ==""){
                file_createDate11 = "2000/01/01 00:00:00";
        }
        if(file_createDate2==null || file_createDate2 ==""){
            file_createDate22 = GlobleService.getDateString(new Date())+" 23:59:59";
        }
        PageInfo<Summary> pageInfo =  workplansService.findWorkByIdNameDate(wpName, file_createDate11,file_createDate22,pageNum,pageSize);

        List<UserDto> userList=userService.selectAllUserDto();
        //查询所有img对应的路径
        for(UserDto u:userList){
            String path=u.getImg();
            String imgstr= ImageBase64Utils.imageToBase64(path);
            u.setImg("data:image/jpeg;base64,"+imgstr);
        }
        if(wpName!=""&&wpName!=null){
            model.addAttribute("wpName",wpName);
        }
        if(file_createDate1!=""&&file_createDate1!=null){
            model.addAttribute("file_createDate1",file_createDate1);
        }
        if(file_createDate2!=""&&file_createDate2!=null){
            model.addAttribute("file_createDate2",file_createDate2);
        }
        model.addAttribute("userList",userList);
        //将获取到的工作计划放入model
        model.addAttribute("pageInfo",pageInfo);
        return "upload";
    }

    /**
     * 搜条件索的工作计划
     * @param model
     * @return
     */
   /* @ResponseBody
    @RequestMapping("/findWorkDateName")
    public Map<String,Object> findWorkById2(Model model, String wpName , String file_createDate1, String file_createDate2,
                                                   @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                   @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){
        Map<String,Object> map = new HashMap<String,Object>();
        //拼接字符串
        String file_createDate11 = file_createDate1+" 00:00:00";
        String file_createDate22 = file_createDate2+" 23:59:59";
        if(file_createDate1==null || file_createDate1 ==""){
            file_createDate11 = "2000/01/01 00:00:00";
        }
        if(file_createDate2==null || file_createDate2 ==""){
            file_createDate22 = GlobleService.getDateString(new Date())+" 23:59:59";
        }
        PageInfo<Summary> pageInfo =  workplansService.findWorkByIdNameDate(wpName, file_createDate11,file_createDate22,pageNum,pageSize);

        List<UserDto> userList=userService.selectAllUserDto();
        //查询所有img对应的路径
        for(UserDto u:userList){
            String path=u.getImg();
            String imgstr= ImageBase64Utils.imageToBase64(path);
            u.setImg("data:image/jpeg;base64,"+imgstr);
        }
        map.put("userList",userList);

        //将获取到的工作计划放入model
        map.put("pageInfo",pageInfo);
        return map;
    }*/
    /**
     * 查看自己的所有文件
     * @param request
     * @return
     */
    @RequestMapping("/findAllWorkById")
    @ResponseBody
    public Map<String,Object> findAllWorkById(HttpServletRequest request,@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                              @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){
        Map<String,Object> map = new HashMap<String,Object>();
        UserEntity userEntity = (UserEntity)request.getSession().getAttribute("user");
        //获取当前用户id
        String t_user_id = userEntity.gettUserId();
        PageInfo<UserWorkPlans> pageInfo =  workplansService.findAllWorkById(t_user_id,pageNum,pageSize);
        map.put("pageInfo",pageInfo);
        return map;
    }

    /**
     * 查看一个文件的详情信息
     */
    @ResponseBody
    @RequestMapping("/getWorkPlansDetailList")
    public Map<String,Object> getWorkPlansDetailList(@Param("tUserId") String tUserId,@Param("wpCreatedate") String wpCreatedate){
        Map<String,Object> map=new HashMap<>();
        List<UserWorkPlans> workPlansList=workplansService.getWorkPlansDetailList(tUserId,wpCreatedate);
        map.put("workPlansList",workPlansList);
       return map;
    }

    /**
     * 提交工作计划总结，即写入自己的实际绩效点
     * @return
     */
    @ResponseBody
    @RequestMapping("/addActual")
    public Map<String,Object> updateWork(HttpServletRequest request,@RequestParam(value="wpIds[]")Integer[] wpIds, @RequestParam(value="wpActualPerformances[]") Integer[] wpActualPerformances){
        Map<String,Object> map = new HashMap<>();
        UserEntity user = (UserEntity) request.getSession().getAttribute("user");

        for(int i=0;i<wpIds.length;i++){
            UserWorkPlans work = workplansService.findOneWork(wpIds[i]);
            //如果该文件不是当前登录用户传的，则不可修改实际绩效点
            if(!user.gettUserId().equals(work.gettUserId())){
                map.put("msg","您不能修改他人工作计划！");
            }else {
                UserWorkPlans workplans = workplansService.findOneWork(wpIds[i]);
                if(workplans.getWpActualPerformance() == 0){
                    int result = workplansService.updateWork(wpActualPerformances[i], wpIds[i]);
                    map.put("msg","提交完毕！");
                    map.put("result", result);
                }else {
                    map.put("msg","已提交的工作无法再次修改！");
                }
            }
        }

        return map;
    }

    /**
     * 领导填写审核绩效点
     * @param wpIds
     * @return
     */
    @ResponseBody
    @RequestMapping("/keyPoint")
    public Map<String,Integer> updateKeypoint(@RequestParam("wpIds[]") Integer[] wpIds,@RequestParam("checkPoints[]") Integer[] checkPoints){
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<wpIds.length;i++) {
            int result = workplansService.updateKeypoint(wpIds[i], checkPoints[i]);
            map.put("result",result);
        }
        return map;
    }
}