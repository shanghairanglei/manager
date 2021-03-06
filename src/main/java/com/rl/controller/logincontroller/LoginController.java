package com.rl.controller.logincontroller;

import com.github.pagehelper.PageInfo;
import com.rl.dto.Summary;
import com.rl.dto.UserDto;
import com.rl.model.Dept;
import com.rl.model.UserEntity;
import com.rl.service.DeptService;
import com.rl.service.UserService;
import com.rl.service.WorkplansService;
import com.rl.utils.GlobleService;
import com.rl.utils.ImageBase64Utils;
import org.apache.ibatis.annotations.Param;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/Login")
public class LoginController {
    @Autowired
    private UserService  userService;

    @Autowired
    private DeptService deptService;

    @Autowired
    private WorkplansService workplansService;

    /**
     * 主页
     * @return
     */
    @RequestMapping("/go")
    public String index() { return "workday"; }
    /**
     * 未进行认证要跳转的页面
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/index";
    }
    /**
     * 未进行授权要跳转的页面
     * @return
     */
    @RequestMapping("/unAuth")
    public String unAuth(){
        return "/index";
    }

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/userLogin")
    public String userLogin(@Param("username") String username,
                            @Param("password")String password,
                            Model model,
                            String wpName ,String file_createDate1,String file_createDate2,
                            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,
                            HttpServletRequest request){
        /**
         * 使用shiro编写认证操作
         */
        HttpSession session=request.getSession();
        //获取当前用户信息
        UserEntity userEntity=userService.selectUserByUsernameAndPassword(username,password);
        if(userEntity!=null){
            userEntity.setImg("data:img/jpg;base64,"+ImageBase64Utils.imageToBase64(userEntity.getImg()));
            session.setAttribute("user",userEntity);
            session.setAttribute("roleId",userService.selectRoleId(userEntity.gettUserId()));
            session.setAttribute("deptId",userEntity.getDeptId());
            Dept dept = deptService.selectDeptById(userEntity.getDeptId());
            session.setAttribute("userDept",dept);
        }
        //获取Subject
        Subject subject = SecurityUtils.getSubject();
        //封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        //执行登录方法
        try {
            //登录成功
            subject.login(token);
            //右侧人员列表处理
            List<UserDto> userList=userService.selectAllUserDto();
            //查询所有img对应的路径
            for(UserDto u:userList){
                String path=u.getImg();
                String imgstr= ImageBase64Utils.imageToBase64(path);
                u.setImg("data:image/jpeg;base64,"+imgstr);
            }
            model.addAttribute("userList",userList);

            //加载所有人工作计划
            String file_createDate11 = file_createDate1+" 00:00:00";
            String file_createDate22 = file_createDate2+" 23:59:59";
            if(file_createDate1==null || file_createDate1 ==""){
                file_createDate11 = "2000/01/01 00:00:00";
            }
            if(file_createDate2==null || file_createDate2 ==""){
                file_createDate22 = GlobleService.getDateString(new Date())+" 23:59:59";
            }
            PageInfo<Summary> pageInfo =  workplansService.findWorkByIdNameDate(wpName, file_createDate11,file_createDate22,pageNum,pageSize);

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
        } catch (UnknownAccountException e) {
            //登录失败
            model.addAttribute("msg","用户名不存在");
            return "index";
        }catch (IncorrectCredentialsException e) {
            //登录失败
            model.addAttribute("msg","密码错误!");
            return "index";
        }
    }

    /**
     * @Author xfx
     * @Date 9:39 2019/9/29
     * @Param [request]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     *  获取角色id
     **/
    @ResponseBody
    @RequestMapping("/getSessionMessage")
    public Map<String,Object> getSessionMessage(HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        map.put("user",request.getSession().getAttribute("user"));
        map.put("roleId",request.getSession().getAttribute("roleId"));
        return map;
    }

}
