package com.s1.controller;

import com.s1.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/url")
public class URLMappingController {
    @GetMapping("/g")
    @ResponseBody
    public String getMapping(@RequestParam("name") String name) {
        return "getMapping..." + name;
    }

//    @PostMapping("/p")
//    @ResponseBody
//    public String postMapping(String username, Long password) {
//        return "postMapping..." + username + " " + password;
//    }

    @PostMapping("/p")
    @ResponseBody
    public String postMapping(String username, @RequestParam("password") Long password) {
        return "postMapping..." + username + " " + password;
    }

    @PostMapping("/p1")
    @ResponseBody
    public String postMapping1(User user) {
        System.out.println("user: " + user.getUsername());
        return "postMapping..." + user.getUsername();
    }
}
