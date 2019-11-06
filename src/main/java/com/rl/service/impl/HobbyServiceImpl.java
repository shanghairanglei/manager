package com.rl.service.impl;

import com.rl.mapper.hobbymapper.HobbyMapper;
import com.rl.model.Hobby;
import com.rl.service.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lzw
 * @date 2019/9/26 15:40
 */
@Service
public class HobbyServiceImpl implements HobbyService {
    @Autowired
    private HobbyMapper hobbyMapper;

    @Override
    public Hobby selectHobbyById(String tUserId) {
        return hobbyMapper.selectHobbyById(tUserId);
    }

    @Override
    public Integer addHobby(Hobby hobby) {
        return hobbyMapper.addHobby(hobby);
    }
}
