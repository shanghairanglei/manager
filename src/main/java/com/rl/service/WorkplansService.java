package com.rl.service;

import com.github.pagehelper.PageInfo;
import com.rl.dto.Summary;
import com.rl.model.Workplans;
import com.rl.vo.UserWorkPlans;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.Date;
import java.util.List;
@Service
public interface WorkplansService {
    int deleteByPrimaryKey(Integer wpId);

    int insert(Workplans record);

    int insertSelective(Workplans record);

    UserWorkPlans selectByWpId(@Param("wpId") Integer wpId);

    int updateByPrimaryKeySelective(Workplans record);

    int updateByPrimaryKey(Workplans record);
    //查看的一个文件
    UserWorkPlans findOneWork(@Param("wpId") Integer wpId);

    /*查看工作计划详情*/
    List<UserWorkPlans> getWorkPlansDetailList(@Param("tUserId") String tUserId,@Param("wpCreatedate") String wpCreatedate);

    List<Workplans> findByDateDept(@Param("deptId") Integer deptId,@Param("file_createDate1") String createDate1, @Param("file_createDate2")String createDate2);
    //添加工作计划
    int insertWork(UserWorkPlans workplans);

    //添加工作计划总结
    int updateWork(@Param("wpActualPerformance") Integer wpActualPerformance,@Param("wpId") Integer wpId,
                   @Param(value="selfTestPerformance") Integer selfTestPerformance, @Param(value="selfActualPerformance") Integer selfActualPerformance);

    //修改审核点
    int updateKeypoint(@Param("wpId") Integer wpId,@Param("checkPoint") Integer checkPoint,
                       @Param("managementWeight") Integer managementWeight,@Param("managementPerformance") Integer managementPerformance,
                       @Param("selfTotalPerformance") Integer selfTotalPerformance,@Param("totalPerformance") Integer totalPerformance);

    PageInfo<Summary> findWorkByIdNameDate(@Param("wpName")String wpName, @Param("file_createDate1") String createDate1,
                                           @Param("file_createDate2")String createDate2,
                                           @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                           @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize);
    //查询自己的所有文件
    PageInfo<UserWorkPlans> findAllWorkById(@Param("t_user_id") String t_user_id,Integer pageNum, Integer pageSize);
    //查看所有人的工作计划
    PageInfo<UserWorkPlans> findAllWork(Integer pageNum, Integer pageSize);

    /*查询所有工作计划*/
    List<UserWorkPlans>  getWorkByIdNameDate(@Param("wpName")String wpName, @Param("file_createDate1") String createDate1,
                                             @Param("file_createDate2")String createDate2);
}
