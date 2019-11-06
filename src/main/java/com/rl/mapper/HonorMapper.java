package com.rl.mapper;

import com.rl.model.Honor;

public interface HonorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Honor record);

    int insertSelective(Honor record);

    Honor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Honor record);

    int updateByPrimaryKey(Honor record);
}