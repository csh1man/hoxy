package com.community.hoxy.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/test")
    public String test(){
        System.out.println("이것은 테스트입니다.");
        return "hoxy project test";
    }
}
