package com.community.hoxy.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping(value="/test")
    public String Test(){
        System.out.println("this is a test");
        return "this is a test";
    }
}
