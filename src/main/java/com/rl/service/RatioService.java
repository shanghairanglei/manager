package com.rl.service;

import com.github.pagehelper.PageInfo;
import com.rl.model.Workplans;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface RatioService {
    /*查询所有人员绩效,除领导,分页*/
    PageInfo<Workplans> selectUserRatioList(Integer pageNum, Integer pageSize, String name, Integer deptId, Date wpStarttime, Date wpEndtime);
}
