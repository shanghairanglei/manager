package com.rl.service;

import com.github.pagehelper.PageInfo;
import com.rl.dto.PerformanceDto;
import com.rl.dto.UserDto;
import com.rl.model.Workplans;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public interface PerformanceService {
    /*个人绩效查询*/
    PageInfo<Workplans> selectPerformanceList(Integer pageNum, Integer pageSize, String tUserId);

    /*查询所属部门*/
    String  selectDepetName(String tUserId);

    /*员工身份查询个人工作计划*/
    List<Workplans> selectWorkPlansBytUserId(String tUserId, String Starttime, String Endtime);

    /*根据姓名查询用户*/
    UserDto searchUserByName(String name);

    /*折线图查询个人绩效(月)*/
    List<PerformanceDto>  selectUserDetailPerformance(String tUserId, String Starttime, String Endtime,Integer total);

    /*折线图查询个人绩效(年)*/
    List<PerformanceDto>  selectUserDetailPerformanceByYear(String tUserId, String Starttime, String Endtime,Integer total);

    /*折线图查询个人绩效(周)*/
    List<PerformanceDto>  selectUserDetailPerformanceByWeek(String tUserId, String Starttime, String Endtime,Integer total);

    /*查询个人工作计划条数*/
    Integer getWorkPlansSum(String tUserId,String Starttime, String Endtime);

    /*查询所有个人工作计划*/
    Integer getAllWorkplansCount(String tUserId);

}
