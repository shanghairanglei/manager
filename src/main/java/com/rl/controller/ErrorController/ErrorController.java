package com.rl.controller.ErrorController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("/400")
    public String to400() {
        return "error/400";
    }
    @RequestMapping("/404")
    public String to404() {
        return "error/404";
    }

    @RequestMapping("/500")
    public String to500() {
        return "error/500";
    }
    @RequestMapping("/505")
    public String to505() {
        return "error/505";
    }
}
