package com.rl.controller.teamcontroller;

import com.rl.dto.UserDto;
import com.rl.model.Dept;
import com.rl.model.Honor;
import com.rl.model.Skill;
import com.rl.model.UserEntity;
import com.rl.service.DeptService;
import com.rl.service.PersonalService;
import com.rl.service.TeamService;
import com.rl.service.UserService;
import com.rl.utils.GlobleService;
import com.rl.utils.ImageBase64Utils;
import com.rl.vo.EduProHobbyVo;
import com.rl.vo.ProjectExpe;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lzw
 * @date 2019/9/27 8:58
 */
@Controller
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private PersonalService personalService;

    @Autowired
    private UserService userService;

    @Autowired
    private DeptService deptService;

    @Autowired
    private TeamService teamService;

    /**
     * 团队介绍
     *
     * @return
     */
    @RequestMapping("/go")
    public String my(Model model, HttpServletRequest request) throws ParseException {
        UserEntity userEntity = (UserEntity)request.getSession().getAttribute("user");
        List<UserEntity> sysEmployeeList=userService.selectUserList();
        for (UserEntity u : sysEmployeeList) {
            u.setCreateTime(GlobleService.getDate(u.getCreateTime()));
            u.setImg("data:img/jpg;base64,"+ ImageBase64Utils.imageToBase64(u.getImg()));
        }

        model.addAttribute("userDeptList",sysEmployeeList);
        //部门集合放入session
        List<Dept> deptList=deptService.selectDept();
        request.getSession().setAttribute("deptList",deptList);

        List<UserDto> userList=userService.selectAllUserDto();
        //查询所有img对应的路径
        for(UserDto u:userList){
            String path=u.getImg();
            String imgstr= ImageBase64Utils.imageToBase64(path);
            u.setImg("data:image/jpeg;base64,"+imgstr);
        }
        model.addAttribute("userList",userList);

        return "team";
    }

    /**
     * 个人详情
     *
     * @return
     */
    @RequestMapping("/Individual")
    public String individual(String tUserId, HttpServletRequest request,Model model) throws ParseException {
        UserEntity user=userService.selectUserByIds(tUserId);
        user.setImg("data:img/jpg;base64,"+ ImageBase64Utils.imageToBase64(user.getImg()));
        model.addAttribute("userDeptList",user);
        //部门集合放入session
        List<Dept> deptList=deptService.selectDept();
        request.getSession().setAttribute("deptList",deptList);
        //查询技能特长
        List<Skill> skill=teamService.selectSkill(tUserId);
        model.addAttribute("skill",skill);
        //查询兴趣爱好
        List<EduProHobbyVo> hobby=personalService.selectHobby(tUserId);
        model.addAttribute("hobby",hobby);
        //查询荣誉
        List<Honor> honor=teamService.selectHonor(tUserId);
        model.addAttribute("honor",honor);

        List<ProjectExpe> project=teamService.selectProject(tUserId);
        model.addAttribute("project",project);
        return "Individual";
    }

    /**
     * 查询用户技能
     *
     * @return
     */
    @RequestMapping("/selectSkill")
    public Map<String,Object> selectSkill(HttpServletRequest request) {
        String tUserId=request.getParameter("tUserId");
        Map<String,Object> map=new HashMap<>();
        List<Skill> skill=teamService.selectSkill(tUserId);
        map.put("skill",skill);
        request.getSession().setAttribute("skill",skill);
        return map;
    }
}
