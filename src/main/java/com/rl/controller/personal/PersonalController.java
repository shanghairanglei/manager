package com.rl.controller.personal;

import com.rl.dto.UserDto;
import com.rl.model.UserEntity;
import com.rl.service.PersonalService;
import com.rl.service.UserService;
import com.rl.utils.FileUtil;
import com.rl.utils.ImageBase64Utils;
import com.rl.vo.EduProHobbyVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.*;

@Controller
@RequestMapping("/personal")
public class PersonalController {
    @Autowired
    private PersonalService personalService;

    @Autowired
    private UserService userService;

    /**
     * 个人中心
     *
     * @return
     */
    @RequestMapping("/go")
    public String my(Model model, HttpServletRequest request) throws ParseException {
        UserEntity userEntity = (UserEntity) request.getSession().getAttribute("user");
        //查询教育经历
        EduProHobbyVo education = personalService.selectEducation(userEntity.gettUserId());
        //查询兴趣爱好
        List<EduProHobbyVo> hobby = personalService.selectHobby(userEntity.gettUserId());
        //查询工作经历
        EduProHobbyVo experience = personalService.selectExperiences(userEntity.gettUserId());
        //查询项目经历
        EduProHobbyVo project = personalService.selectProject(userEntity.gettUserId());

        //查询个人
        UserEntity dbuser=userService.selectUserByIds(userEntity.gettUserId());
        dbuser.setImg("data:img/jpg;base64,"+ImageBase64Utils.imageToBase64(dbuser.getImg()));
        model.addAttribute("dbuser",dbuser);
        model.addAttribute("education", education);
        model.addAttribute("hobby", hobby);
        model.addAttribute("experience", experience);
        model.addAttribute("project", project);

        List<UserDto> userList = userService.selectAllUserDto();
        //查询所有img对应的路径
        for (UserDto u : userList) {
            String path = u.getImg();
            String imgstr = ImageBase64Utils.imageToBase64(path);
            u.setImg("data:image/jpeg;base64," + imgstr);
        }
        model.addAttribute("userList", userList);
        return "personal";
    }

    //修改头像
    @RequestMapping("/UploadImg")
    @ResponseBody
    public Map uploadFile(@RequestParam(value = "fileName", required = false) MultipartFile file,HttpServletRequest request) {
        String result_msg = "";//上传结果信息
        Map<String, Object> map = new HashMap<String, Object>();
        UserEntity userEntity = (UserEntity) request.getSession().getAttribute("user");

        if (file.getSize() / 10000000 > 1000) {
            result_msg = "图片大小不能超过1000KB";
        } else {
            //
            //判断上传文件格式
            String fileType = file.getContentType();
            if (fileType.equals("image/jpeg") || fileType.equals("image/png") || fileType.equals("image/jpeg")) {
                final String localPath = "/project/image";
                //获取文件名
                String fileName = file.getOriginalFilename();
                //获取文件后缀名
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                //重新生成文件名
                fileName = UUID.randomUUID() + suffixName;
                String realPath = localPath + "/" + fileName;
                Integer result=personalService.UploadImg(userEntity.gettUserId(),realPath);
                if (FileUtil.upload(file, localPath, fileName)&&result==1) {
                    //文件存放的相对路径
                    String relativePath = "image/" + fileName;
                    map.put("relativePath", relativePath);//前端根据是否存在该字段来判断上传是否成功
                    result_msg="图片上传成功";
                    String imgstr = ImageBase64Utils.imageToBase64(realPath);
                    userEntity.setImg("data:image/jpeg;base64," + imgstr);
                }
                else{
                    result_msg="图片上传失败";
                }
            }
            else{
                result_msg="图片格式不正确";
            }
        }
        map.put("result", result_msg);
        return map;

    }

    //修改密码
    @RequestMapping("/UpdatePassWord")
    @ResponseBody
    public Map<String, Object> UpdatePassWord(HttpServletRequest request, String password, String newPassword, String conPassword, Model model) {
        Map<String, Object> map = new HashMap<>();
        UserEntity userEntity = (UserEntity) request.getSession().getAttribute("user");
        UserEntity user = userService.selectUserByIds(userEntity.gettUserId());
        if (!password.equals(user.getPassword())) {
            map.put("msg", "原密码不正确!");
            return map;
        } else if (!newPassword.equals(conPassword)) {
            map.put("msg", "确认密码和新密码不一致!");
            return map;
        } else if (newPassword.equals(user.getPassword())) {
            map.put("msg", "新密码不能和原密码相同!");
            return map;
        } else {
            Integer result = personalService.UpdatePassWord(userEntity.gettUserId(), password, newPassword, conPassword);
            map.put("msg", result);
            return map;
        }
    }

    //修改个人简介
    @RequestMapping("/UpdateProfile")
    @ResponseBody
    public Map<String, Object> UpdateProfile(@Param(value = "tUserId") String tUserId, @Param(value = "newDescription") String newDescription) {
        Map<String, Object> map = new HashMap<>();
        Integer result = personalService.UpdateProfile(tUserId, newDescription);
        map.put("profile", result);
        return map;
    }

    /*查询教育详情*/
    @ResponseBody
    @RequestMapping("/selectEducation")
    public Map<String, Object> selectEducation(HttpServletRequest request) {
        String tUserId = request.getParameter("tUserId");
        Map<String, Object> map = new HashMap<>();
        EduProHobbyVo eduProHobbyVo = personalService.selectEducation(tUserId);
        map.put("eduProHobbyVo", eduProHobbyVo);
        request.getSession().setAttribute("eduProHobbyVo", eduProHobbyVo);
        return map;
    }

    /**
     * 修改教育信息
     **/
    @ResponseBody
    @RequestMapping("/updateEducation")
    public Map<String, Object> updateEducation(EduProHobbyVo eduProHobbyVo, HttpServletRequest request,Model model) {
        UserEntity userEntity = (UserEntity) request.getSession().getAttribute("user");
        Map<String, Object> map = new HashMap<>();
        eduProHobbyVo.settUserId(userEntity.gettUserId());
        EduProHobbyVo eduProHobbyVos = personalService.selectEducation(eduProHobbyVo.gettUserId());
        if (eduProHobbyVos!= null) {
            Integer result = personalService.updateEducation(eduProHobbyVo);
            map.put("education", result);
        }else {
            Integer result = personalService.InsertEducation(eduProHobbyVo);
            map.put("education", result);
        }
        List<UserDto> userList = userService.selectAllUserDto();
        //查询所有img对应的路径
        for (UserDto u : userList) {
            String path = u.getImg();
            String imgstr = ImageBase64Utils.imageToBase64(path);
            u.setImg("data:image/jpeg;base64," + imgstr);
        }
        model.addAttribute("userList", userList);
        return map;
    }

    /*查询工作详情*/
    @ResponseBody
    @RequestMapping("/selectExperience")
    public Map<String, Object> selectExperiences(HttpServletRequest request) {
        String tUserId = request.getParameter("tUserId");
        Map<String, Object> map = new HashMap<>();
        EduProHobbyVo experience = personalService.selectExperiences(tUserId);
        map.put("experience", experience);
        request.getSession().setAttribute("experience", experience);
        return map;
    }

    /**
     * 修改工作经历
     **/
    @ResponseBody
    @RequestMapping("/updateExperience")
    public Map<String, Object> updateExperience(EduProHobbyVo eduProHobbyVo, HttpServletRequest request, Model model) {
        UserEntity userEntity = (UserEntity) request.getSession().getAttribute("user");
        Map<String, Object> map = new HashMap<>();
        eduProHobbyVo.settUserId(userEntity.gettUserId());
        EduProHobbyVo experience = personalService.selectExperiences(eduProHobbyVo.gettUserId());
        if (experience != null){
            Integer result = personalService.updateExperience(eduProHobbyVo);
            map.put("experience", result);
        }else {
            Integer result = personalService.InsertExperience(eduProHobbyVo);
            map.put("experience", result);
        }

        List<UserDto> userList = userService.selectAllUserDto();
        //查询所有img对应的路径
        for (UserDto u : userList) {
            String path = u.getImg();
            String imgstr = ImageBase64Utils.imageToBase64(path);
            u.setImg("data:image/jpeg;base64," + imgstr);
        }
        model.addAttribute("userList", userList);
        return map;
    }

    /*查询项目详情*/
    @ResponseBody
    @RequestMapping("/selectProject")
    public Map<String, Object> selectProject(HttpServletRequest request) {
        String tUserId = request.getParameter("tUserId");
        Map<String, Object> map = new HashMap<>();
        EduProHobbyVo project = personalService.selectProject(tUserId);
        map.put("project", project);
        request.getSession().setAttribute("project", project);
        return map;
    }

    /**
     * 修改项目经历
     **/
    @ResponseBody
    @RequestMapping("/updateProject")
    public Map<String, Object> updateProject(EduProHobbyVo eduProHobbyVo, HttpServletRequest request, Model model) {
        UserEntity userEntity = (UserEntity) request.getSession().getAttribute("user");
        Map<String, Object> map = new HashMap<>();
        eduProHobbyVo.settUserId(userEntity.gettUserId());
        EduProHobbyVo project = personalService.selectProject(eduProHobbyVo.gettUserId());
        if (project != null){
            Integer result = personalService.updateProject(eduProHobbyVo);
            map.put("project", result);
        }else {
            eduProHobbyVo.settUserId(userEntity.gettUserId());
            EduProHobbyVo experience = personalService.selectExperiences(eduProHobbyVo.gettUserId());
            eduProHobbyVo.seteId(experience.geteId());
            Integer result = personalService.InsertProject(eduProHobbyVo);
            map.put("project", result);
        }

        List<UserDto> userList = userService.selectAllUserDto();
        //查询所有img对应的路径
        for (UserDto u : userList) {
            String path = u.getImg();
            String imgstr = ImageBase64Utils.imageToBase64(path);
            u.setImg("data:image/jpeg;base64," + imgstr);
        }
        model.addAttribute("userList", userList);
        return map;
    }

}
