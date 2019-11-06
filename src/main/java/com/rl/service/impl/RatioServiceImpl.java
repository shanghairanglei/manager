package com.rl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rl.mapper.ratiomapper.RatioMapper;
import com.rl.model.Workplans;
import com.rl.service.RatioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RatioServiceImpl implements RatioService {
    @Autowired
    private RatioMapper ratioMapper;

    /*查询所有人员绩效,除领导,分页*/
    @Override
    public PageInfo<Workplans> selectUserRatioList(Integer pageNum, Integer pageSize, String name, Integer deptId, Date wpStarttime, Date wpEndtime) {
        wpEndtime=new Date();
        PageHelper.startPage(pageNum,pageSize);
        List<Workplans>  rlWorkplansList=ratioMapper.selectUserRatioList(name,deptId,wpStarttime,wpEndtime);
        PageInfo<Workplans> rlWorkplansInfo=new PageInfo<>(rlWorkplansList);
        return rlWorkplansInfo;
    }
}
