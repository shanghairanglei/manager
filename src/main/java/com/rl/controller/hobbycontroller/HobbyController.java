package com.rl.controller.hobbycontroller;

import com.rl.service.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lzw
 * @date 2019/9/26 16:09
 */
@Controller
@RequestMapping("hobby")
public class HobbyController {
    @Autowired
    private HobbyService hobbyService;
}
