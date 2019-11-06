package com.rl.service.impl;

import com.rl.mapper.PermissionMapper;
import com.rl.model.Permission;
import com.rl.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Permission record) {
        return 0;
    }

    @Override
    public int insertSelective(Permission record) {
        return 0;
    }

    @Override
    public Permission selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Permission record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Permission record) {
        return 0;
    }

    @Override
    public List<String> selectPermsUrlListById(int id) {
        return permissionMapper.selectPermsUrlListById(id);
    }
}
