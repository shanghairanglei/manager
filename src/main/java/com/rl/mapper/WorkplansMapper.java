package com.rl.mapper;

import com.github.pagehelper.PageInfo;
import com.rl.dto.Summary;
import com.rl.model.Workplans;
import com.rl.vo.UserWorkPlans;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface WorkplansMapper {
    int deleteByPrimaryKey(Integer wpId);

    int insert(Workplans record);

    int insertSelective(Workplans record);

    UserWorkPlans selectByWpId(@Param("wpId") Integer wpId);

    int updateByPrimaryKeySelective(Workplans record);

    int updateByPrimaryKey(Workplans record);

    //查看的一个文件详情
    UserWorkPlans findOneWork(@Param("wpId") Integer wpId);

    /*查看工作计划详情*/
    List<UserWorkPlans> getWorkPlansDetailList(@Param("tUserId") String tUserId,@Param("wpCreatedate") String wpCreatedate);

    //根据创建日期和部门查询工作计划
    List<Workplans> findByDateDept(@Param("deptId") Integer deptId,@Param("file_createDate1") String file_createDate1, @Param("file_createDate2")String file_createDate2);

    //添加工作计划
    int insertWork(UserWorkPlans workplans);

    //添加工作计划总结(下午提交实际绩效点)
    int updateWork(@Param("wpActualPerformance") Integer wpActualPerformance,@Param("wpId") Integer wpId);

    //修改审核点(领导)
    int updateKeypoint(@Param("wpId") Integer wpId,@Param("checkPoint") Integer checkPoint);
    
    //按照标题和时间查找自己的工作计划
    List<Summary> findWorkByIdNameDate(@Param("wpName") String wpName,
                                       @Param("file_createDate1") String file_createDate1,
                                       @Param("file_createDate2")String file_createDate2, Integer pageNum, Integer pageSize);

    //查询自己的所有工作计划
    List<UserWorkPlans> findAllWorkById(@Param("t_user_id") String t_user_id, Integer pageNum, Integer pageSize);
    //查看所有人的工作计划
    List<UserWorkPlans> findAllWork(Integer pageNum, Integer pageSize);

    /*查询所有工作计划*/
    List<UserWorkPlans>  getWorkByIdNameDate(@Param("wpName")String wpName, @Param("file_createDate1") String createDate1,
                                             @Param("file_createDate2")String createDate2);
    //查询一个人的总工作记录数
    Integer getWorkCountBywpName(@Param("wpName")String wpName);


}