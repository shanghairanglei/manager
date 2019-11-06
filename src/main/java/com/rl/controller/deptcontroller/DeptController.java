package com.rl.controller.deptcontroller;

import com.rl.model.Dept;
import com.rl.model.UserEntity;
import com.rl.service.DeptService;
import com.rl.vo.UserDept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lzw
 * @date 2019/9/16 16:33
 */
@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping("/selectDeptList")
    public Dept selectDeptList(Integer deptId) {
        Dept dept=deptService.selectDeptById(deptId);
        return dept;
    }

    @RequestMapping("/selectDept")
    public String selectDept(Model model, HttpServletRequest request) {
        List<Dept> deptList=deptService.selectDept();
        request.getSession().setAttribute("deptList",deptList);
        return "member";
    }

}
