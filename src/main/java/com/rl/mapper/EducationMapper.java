package com.rl.mapper;

import com.rl.model.Education;

public interface EducationMapper {
    int insert(Education record);

    int insertSelective(Education record);
}