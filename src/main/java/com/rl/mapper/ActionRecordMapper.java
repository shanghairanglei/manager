package com.rl.mapper;

import com.rl.model.ActionRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ActionRecordMapper {
    int deleteByPrimaryKey(Integer actionId);

    int insert(ActionRecord record);

    int insertSelective(ActionRecord record);

    ActionRecord selectByPrimaryKey(Integer actionId);

    int updateByPrimaryKeySelective(ActionRecord record);

    int updateByPrimaryKey(ActionRecord record);
}