package com.rl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graphbuilder.math.func.SumFunction;
import com.mysql.jdbc.log.LogUtils;
import com.rl.dto.Summary;
import com.rl.mapper.WorkplansMapper;
import com.rl.model.Workplans;
import com.rl.service.WorkplansService;
import com.rl.vo.UserWorkPlans;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class WorkplansServiceImpl implements WorkplansService {

    @Autowired
    private WorkplansMapper workplansMapper;

    @Override
    public int deleteByPrimaryKey(Integer wpId) {
        return 0;
    }

    @Override
    public int insert(Workplans record) {
        return 0;
    }

    @Override
    public int insertSelective(Workplans record) {
        return 0;
    }

    @Override
    public UserWorkPlans selectByWpId(Integer wpId) {
        return workplansMapper.selectByWpId(wpId);
    }


    @Override
    public int updateByPrimaryKeySelective(Workplans record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Workplans record) {
        return 0;
    }

    @Override
    public UserWorkPlans  findOneWork(Integer wpId) {
        return workplansMapper.findOneWork(wpId);
    }

    /*查看工作计划详情*/
    @Override
    public List<UserWorkPlans> getWorkPlansDetailList(String tUserId, String wpCreatedate) {
        return workplansMapper.getWorkPlansDetailList(tUserId,wpCreatedate);
    }

    @Override
    public List<Workplans> findByDateDept(Integer deptId,String createDate1,String createDate2) {
        return workplansMapper.findByDateDept(deptId,createDate1,createDate2);
    }

    @Override
    public int insertWork(UserWorkPlans workplans) {

        return workplansMapper.insertWork(workplans);

    }

    @Override
    public int updateWork(Integer wpActualPerformance,Integer wpId) {
        return workplansMapper.updateWork(wpActualPerformance,wpId);
    }

    @Override
    public int updateKeypoint(Integer wpId,Integer checkPoint) {
        return workplansMapper.updateKeypoint(wpId,checkPoint);
    }

    @Override
    public PageInfo<Summary> findWorkByIdNameDate(String wpName,String file_createDate1,
                                                        String file_createDate2,
                                                        Integer pageNum,
                                                        Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Summary> userWorkPlansList=workplansMapper.findWorkByIdNameDate(wpName,file_createDate1,file_createDate2,pageNum,pageSize);
        PageInfo<Summary> pageInfo = new PageInfo<>(userWorkPlansList,5);
        return pageInfo;
    }

    @Override
    public PageInfo<UserWorkPlans> findAllWorkById(String t_user_id,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserWorkPlans> list = workplansMapper.findAllWorkById(t_user_id,pageNum,pageSize);
        PageInfo<UserWorkPlans> pageInfo = new PageInfo<>(list,5);
        return pageInfo;
    }

    @Override
    public PageInfo<UserWorkPlans> findAllWork(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserWorkPlans> list = workplansMapper.findAllWork(pageNum,pageSize);
        PageInfo<UserWorkPlans> pageInfo = new PageInfo<>(list,5);
        return pageInfo;
    }

    /*查询所有工作计划*/
    @Override
    public List<UserWorkPlans> getWorkByIdNameDate(String wpName, String createDate1, String createDate2) {
        return workplansMapper.getWorkByIdNameDate(wpName,createDate1,createDate2);
    }
}
