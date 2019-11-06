package com.rl.mapper.hobbymapper;

import com.rl.model.Hobby;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface HobbyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hobby record);

    int insertSelective(Hobby record);

    Hobby selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hobby record);

    int updateByPrimaryKey(Hobby record);

    //查询兴趣爱好
    Hobby selectHobbyById(String tUserId);

    //添加兴趣爱好
    Integer addHobby(Hobby hobby);
}