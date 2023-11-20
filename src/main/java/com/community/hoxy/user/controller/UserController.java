package com.community.hoxy.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/test")
    public String test(){
        System.out.println("this is a test");
        return "hoxy project test";
    }
}
