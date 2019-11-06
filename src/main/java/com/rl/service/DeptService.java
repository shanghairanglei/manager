package com.rl.service;

import com.rl.model.Dept;
import com.rl.model.UserEntity;
import com.rl.vo.UserDept;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzw
 * @date 2019/9/16 16:23
 */
@Service
public interface DeptService {
    //通过部门id查部门内容
    Dept selectDeptById(@Param("deptId") Integer deptId);
    //通过部门名称查部门内容
    Dept selectDeptByName(@Param("deptName") String deptName);
    //查询所有部门
    List<Dept> selectDept();

}
