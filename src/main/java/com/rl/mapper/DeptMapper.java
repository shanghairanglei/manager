package com.rl.mapper;

import com.rl.model.Dept;
import com.rl.model.UserEntity;
import com.rl.vo.UserDept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {
    int deleteByPrimaryKey(Integer deptId);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer deptId);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    //通过部门id查部门内容
    Dept selectDeptById(@Param("deptId") Integer deptId);

    //通过部门名称查部门内容
    Dept selectDeptByName(@Param("deptName") String deptName);

    //查询所有部门
    List<Dept> selectDept();

}