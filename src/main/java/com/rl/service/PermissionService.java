package com.rl.service;

import com.rl.model.Permission;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PermissionService {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    List<String> selectPermsUrlListById(int id);
}
