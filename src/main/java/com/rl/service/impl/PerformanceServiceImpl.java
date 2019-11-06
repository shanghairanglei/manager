package com.rl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rl.dto.PerformanceDto;
import com.rl.dto.UserDto;
import com.rl.mapper.performancemapper.PerformanceMapper;
import com.rl.model.Workplans;
import com.rl.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceServiceImpl implements PerformanceService {
    @Autowired
    private PerformanceMapper performanceMapper;
    /*个人绩效查询*/
    @Override
    public PageInfo<Workplans> selectPerformanceList(Integer pageNum, Integer pageSize, String tUserId) {
        PageHelper.startPage(pageNum,pageSize);
        List<Workplans> rlWorkplansList=performanceMapper.selectPerformanceList(tUserId);
        PageInfo<Workplans> plansInfo=new PageInfo<>(rlWorkplansList);
        return plansInfo;
    }

    /*查询所属部门*/
    @Override
    public String selectDepetName(String tUserId) {
        return performanceMapper.selectDepetName(tUserId);
    }

    /*员工身份查询个人工作计划*/
    @Override
    public List<Workplans> selectWorkPlansBytUserId(String tUserId, String wpStarttime, String wpEndtime) {
        return performanceMapper.selectWorkPlansBytUserId(tUserId,wpStarttime,wpEndtime);
    }

    /*根据姓名查询用户*/
    @Override
    public UserDto searchUserByName(String name) {
        return performanceMapper.searchUserByName(name);
    }

    //折线图查询个人绩效
    @Override
    public List<PerformanceDto> selectUserDetailPerformance(String tUserId, String Starttime, String Endtime,Integer total) {
        return performanceMapper.selectUserDetailPerformance(tUserId,Starttime,Endtime,total);
    }

    //折线图查询个人绩效(年)
    @Override
    public List<PerformanceDto> selectUserDetailPerformanceByYear(String tUserId, String Starttime, String Endtime, Integer total) {
        return performanceMapper.selectUserDetailPerformanceByYear(tUserId,Starttime,Endtime,total);
    }

    //折线图查询个人绩效(周)
    @Override
    public List<PerformanceDto> selectUserDetailPerformanceByWeek(String tUserId, String Starttime, String Endtime, Integer total) {
        return performanceMapper.selectUserDetailPerformanceByWeek(tUserId,Starttime,Endtime,total);
    }

    /*查询个人工作计划条数*/
    @Override
    public Integer getWorkPlansSum(String tUserId, String Starttime, String Endtime) {
        return performanceMapper.getWorkPlansSum(tUserId,Starttime,Endtime);
    }

    /*查询所有个人工作计划*/
    @Override
    public Integer getAllWorkplansCount(String tUserId) {
        return performanceMapper.getAllWorkplansCount(tUserId);
    }

}
