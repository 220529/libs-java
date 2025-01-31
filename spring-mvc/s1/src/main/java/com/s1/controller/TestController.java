package com.s1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @GetMapping("/t") //localhost/t
    @ResponseBody //直接向响应输出字符串数据,不跳转页面
    public String test(){
        return "Hello Spring MVC";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam String name, @RequestParam int age) {
        // 处理参数
        return "greeting";
    }
}