package com.rl.controller.usercontroller;

import com.github.pagehelper.PageInfo;
import com.rl.dto.UserDto;
import com.rl.model.Dept;
import com.rl.model.UserEntity;
import com.rl.service.DeptService;
import com.rl.service.UserService;
import com.rl.utils.GlobleService;
import com.rl.utils.ImageBase64Utils;
import com.rl.vo.EduProHobbyVo;
import com.rl.vo.UserDept;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author lzw
 * @date 2019/8/26 16:13
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private DeptService deptService;
    /**
     * 人员管理
     *
     * @return
     */

    @RequestMapping("/go")
    public String myMember(Model model,HttpServletRequest request,
                           @RequestParam(value="pageNum",defaultValue="1")Integer pageNum,
                           @RequestParam(value="pageSize",defaultValue="8")Integer pageSize) throws ParseException {
        //分页
        PageInfo<UserEntity> pageInfo =userService.selectUserLists(pageNum,pageSize);
        for (UserEntity u : pageInfo.getList()) {
            u.setCreateTime(GlobleService.getDate(u.getCreateTime()));
            u.setImg("data:img/jpg;base64,"+ImageBase64Utils.imageToBase64(u.getImg()));
        }
        model.addAttribute("pageInfo", pageInfo);

//        UserEntity userEntity = (UserEntity)request.getSession().getAttribute("user");
        List<UserEntity> sysEmployeeList=userService.selectUserList();
        for (UserEntity u : sysEmployeeList) {
            u.setCreateTime(GlobleService.getDate(u.getCreateTime()));
            u.setImg("data:img/jpg;base64,"+ImageBase64Utils.imageToBase64(u.getImg()));
        }
        request.getSession().setAttribute("userDeptList",sysEmployeeList);
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
        return "member";
    }
    /**
     * @Author xfx
     * @Date 15:17 2019/8/13
     * @Param
     * @return
     * 查询员工列表
     **/
    @ResponseBody
    @RequestMapping("/selectUserList")
    public String selectUserList(Model model,HttpServletRequest request){
        List<UserEntity> sysEmployeeList=userService.selectUserList();
        List<UserDto> userList=userService.selectAllUserDto();
        //查询所有img对应的路径
        for(UserDto u:userList){
            String path=u.getImg();
            String imgstr= ImageBase64Utils.imageToBase64(path);
            u.setImg("data:image/jpeg;base64,"+imgstr);
        }
        model.addAttribute("userList",userList);
        return "member";
    }

    /**
     * @Author xfx
     * @Date 15:38 2019/8/13
     * @Param
     * 添加员工
     * @return
     **/
    @RequestMapping("/addUser")
    public String addUser(UserEntity user,Model model, @RequestParam(value="pageNum",defaultValue="1")Integer pageNum,
                          @RequestParam(value="pageSize",defaultValue="8")Integer pageSize) throws ParseException {
        Map<String,Object> map=new HashMap<>();
        Integer result = userService.addUser(user);
        map.put("result",result);

        PageInfo<UserEntity> pageInfo =userService.selectUserLists(pageNum,pageSize);
        for (UserEntity u : pageInfo.getList()) {
            u.setCreateTime(GlobleService.getDate(u.getCreateTime()));
            u.setImg("data:img/jpg;base64,"+ImageBase64Utils.imageToBase64(u.getImg()));
        }
        model.addAttribute("pageInfo", pageInfo);

        List<UserDto> userList=userService.selectAllUserDto();
        //查询所有img对应的路径
        for(UserDto u:userList){
            String path=u.getImg();
            String imgstr= ImageBase64Utils.imageToBase64(path);
            u.setImg("data:image/jpeg;base64,"+imgstr);
        }
        model.addAttribute("userList",userList);
        return "member";
    }

    /**
     * @Author xfx
     * @Date 15:49 2019/8/13
     * @Param
     * @return
     * 修改员工基本信息
     **/
    @RequestMapping("/updateUserByEmId")
    public String updateUserByEmId(UserEntity user,Model model, @RequestParam(value="pageNum",defaultValue="1")Integer pageNum,
                                   @RequestParam(value="pageSize",defaultValue="8")Integer pageSize) throws ParseException {
        Map<String,Object> map=new HashMap<>();
        map.put("update",userService.updateUserByEmId(user));

        //分页
        PageInfo<UserEntity> pageInfo =userService.selectUserLists(pageNum,pageSize);
        for (UserEntity u : pageInfo.getList()) {
            u.setCreateTime(GlobleService.getDate(u.getCreateTime()));
            u.setImg("data:img/jpg;base64,"+ImageBase64Utils.imageToBase64(u.getImg()));
        }
        model.addAttribute("pageInfo", pageInfo);

        List<UserDto> userList=userService.selectAllUserDto();
        //查询所有img对应的路径
        for(UserDto u:userList){
            String path=u.getImg();
            String imgstr= ImageBase64Utils.imageToBase64(path);
            u.setImg("data:image/jpeg;base64,"+imgstr);
        }
        model.addAttribute("userList",userList);


        return "member";
    }

    /**
     * @Author xfx
     * @Date 15:57 2019/8/13
     * @Param
     * @return
     * 删除员工
     **/
    @ResponseBody
    @RequestMapping("/deleteUserById")
    public Map<String,Object> deleteUserById(@Param(value = "tUserId")String tUserId, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        Integer result=userService.deleteUserById(tUserId);
        map.put("result",result);
        return map;
    }
    /**
     * @Author xfx
     * @Date 16:01 2019/8/13
     * @Param
     * @return
     * 查询员工详情
     **/
    @ResponseBody
    @RequestMapping("/selectUserByIds")
    public Map<String,Object> selectUserByIds(HttpServletRequest request){
        String tUserId=request.getParameter("tUserId");
        Map<String,Object> map=new HashMap<>();
        UserEntity user=userService.selectUserByIds(tUserId);
        map.put("user",user);
//        request.getSession().setAttribute("user",user);
        return  map;
    }

    /**
     * @Author xfx
     * @Date 16:11 2019/8/13
     * @Param
     * @return
     * 按照姓名搜索或者按照部门方式搜索
     **/
    @RequestMapping("/selectUserByNameDeptName")
    public String selectUserBydeptIdOrName(HttpServletRequest request,@Param(value ="name")String name,
                                           @Param(value ="deptName")String deptName,
                                           @RequestParam(value="pageNum",defaultValue="1")Integer pageNum,
                                           @RequestParam(value="pageSize",defaultValue="8")Integer pageSize,
                                           Model model) throws ParseException {
        if("请选择部门".equals(deptName)){
            deptName="";
        }
       PageInfo<UserDept> pageInfo = userService.selectUserByNameDeptName(name,deptName,pageNum,pageSize);
       for (UserDept u : pageInfo.getList()) {
            u.setCreateTime(GlobleService.getDate(u.getCreateTime()));
            u.setImg("data:img/jpg;base64,"+ImageBase64Utils.imageToBase64(u.getImg()));
        }
        model.addAttribute("pageInfo", pageInfo);

        List<UserDto> userList=userService.selectAllUserDto();
        //查询所有img对应的路径
        for(UserDto u:userList){
            String path=u.getImg();
            String imgstr= ImageBase64Utils.imageToBase64(path);
            u.setImg("data:image/jpeg;base64,"+imgstr);
        }
        model.addAttribute("userList",userList);
        return "member";
    }

    /**
     * 查询人员列表,分页
     **/
    @RequestMapping("/selectUserLists")
    public String selectUserLists(Model model,@RequestParam(required=true,value="pageNum",defaultValue="1")Integer pageNum,
                                  @RequestParam(required=true,value="pageSize",defaultValue="3")Integer pageSize){
        PageInfo<UserEntity> pageInfo =userService.selectUserLists(pageNum,pageSize);
        model.addAttribute("pageInfo", pageInfo);
        List<UserDto> userList=userService.selectAllUserDto();
        //查询所有img对应的路径
        for(UserDto u:userList){
            String path=u.getImg();
            String imgstr= ImageBase64Utils.imageToBase64(path);
            u.setImg("data:image/jpeg;base64,"+imgstr);
        }
        model.addAttribute("userList",userList);
        return "member";
    }

    /**
     * 查询员工图片
     **/
    @RequestMapping("/selectUserImg")
    @ResponseBody
    public  List<UserEntity> selectUserImg() {
        List<UserEntity> result = userService.selectUserImg();
        for (int i = 0 ; i < result.size() ; i++){
            UserEntity u=result.get(i);
            u.setImg(ImageBase64Utils.imageToBase64(u.getImg()));
        }
        return result;
    }
}
