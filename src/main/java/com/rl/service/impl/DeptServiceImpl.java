package com.rl.service.impl;

import com.rl.mapper.DeptMapper;
import com.rl.model.Dept;
import com.rl.service.DeptService;
import com.rl.vo.UserDept;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzw
 * @date 2019/9/16 16:26
 */
@Service
public class DeptServiceImpl implements DeptService {
        @Autowired
        private DeptMapper deptMapper;

        //通过部门id查部门内容
        @Override
        public Dept selectDeptById(Integer deptId) {
            return deptMapper.selectDeptById(deptId);
        }

        //通过部门名称查部门内容
        @Override
        public Dept selectDeptByName(String deptName) {
                return deptMapper.selectDeptByName(deptName);
        }

        //查询所有部门
        @Override
        public List<Dept> selectDept() {
            return deptMapper.selectDept();
        }
}
