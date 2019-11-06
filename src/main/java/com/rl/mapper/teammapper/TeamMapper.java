package com.rl.mapper.teammapper;

import com.rl.model.Honor;
import com.rl.model.Skill;
import com.rl.vo.ProjectExpe;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lzw
 * @date 2019/9/29 14:21
 */
@Mapper
@Repository
public interface TeamMapper {

      //查询技能特长
      List<Skill> selectSkill(@Param(value ="tUserId")String tUserId);

      //查询荣誉
      List<Honor> selectHonor(@Param(value ="tUserId")String tUserId);

      //查询项目经历
      List<ProjectExpe> selectProject(@Param(value ="tUserId")String tUserId);
}
