package com.rl.service.impl;

import com.rl.mapper.teammapper.TeamMapper;
import com.rl.model.Honor;
import com.rl.model.Skill;
import com.rl.service.TeamService;
import com.rl.vo.ProjectExpe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzw
 * @date 2019/9/29 16:13
 */
@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamMapper teamMapper;

    @Override
    public List<Skill> selectSkill(String tUserId) {
        return teamMapper.selectSkill(tUserId);
    }

    @Override
    public List<Honor> selectHonor(String tUserId) {
        return teamMapper.selectHonor(tUserId);
    }

    @Override
    public List<ProjectExpe> selectProject(String tUserId) {
        return teamMapper.selectProject(tUserId);
    }
}
