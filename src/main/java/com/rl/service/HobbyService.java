package com.rl.service;

import com.rl.model.Hobby;
import org.springframework.stereotype.Service;

/**
 * @author lzw
 * @date 2019/9/26 15:40
 */
@Service
public interface HobbyService {
    //查询兴趣爱好
    Hobby selectHobbyById(String tUserId);

    //添加兴趣爱好
    Integer addHobby(Hobby hobby);
}
