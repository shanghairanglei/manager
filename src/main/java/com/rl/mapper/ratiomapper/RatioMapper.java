package com.rl.mapper.ratiomapper;

import com.rl.model.Workplans;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface RatioMapper {
    //查询所有人员绩效,除领导,分页
    List<Workplans> selectUserRatioList(String name, Integer deptId, Date wpStarttime, Date wpEndtime);
}
