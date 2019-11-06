package com.rl.mapper;

import com.rl.model.Experience;

public interface ExperienceMapper {
    int deleteByPrimaryKey(Integer eId);

    int insert(Experience record);

    int insertSelective(Experience record);

    Experience selectByPrimaryKey(Integer eId);

    int updateByPrimaryKeySelective(Experience record);

    int updateByPrimaryKeyWithBLOBs(Experience record);

    int updateByPrimaryKey(Experience record);
}