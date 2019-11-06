package com.rl.mapper.performancemapper;

import com.rl.dto.PerformanceDto;
import com.rl.dto.UserDto;
import com.rl.model.Workplans;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Mapper
@Repository
public interface PerformanceMapper {
    /*个人绩效查询*/
    List<Workplans> selectPerformanceList(String tUserId);

    /*查询所属部门*/
    String  selectDepetName(String tUserId);

    /*员工身份查询个人工作计划*/
    List<Workplans> selectWorkPlansBytUserId(@Param(value = "tUserId") String tUserId, @Param(value = "Starttime") String Starttime,@Param(value = "Endtime") String Endtime);

    /*根据姓名查询用户*/
    UserDto searchUserByName(@Param(value = "name") String name);

    /*折线图查询个人绩效(月)*/
    List<PerformanceDto>  selectUserDetailPerformance(@Param(value = "tUserId")String tUserId, @Param(value = "Starttime")String Starttime, @Param(value = "Endtime")String Endtime,@Param(value = "total")Integer total);

    /*折线图查询个人绩效(年)*/
    List<PerformanceDto>  selectUserDetailPerformanceByYear(@Param(value = "tUserId")String tUserId, @Param(value = "Starttime")String Starttime, @Param(value = "Endtime")String Endtime,@Param(value = "total")Integer total);

    /*折线图查询个人绩效(周)*/
    List<PerformanceDto>  selectUserDetailPerformanceByWeek(@Param(value = "tUserId")String tUserId, @Param(value = "Starttime")String Starttime, @Param(value = "Endtime")String Endtime,@Param(value = "total")Integer total);

    /*查询个人工作计划条数*/
    Integer getWorkPlansSum(@Param(value = "tUserId") String tUserId, @Param(value = "Starttime") String Starttime,@Param(value = "Endtime") String Endtime);

    /*查询所有个人工作计划*/
    Integer getAllWorkplansCount(@Param(value = "tUserId")String tUserId);

}
