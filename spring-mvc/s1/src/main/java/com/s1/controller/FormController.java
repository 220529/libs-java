package com.s1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FormController {
    @PostMapping("/apply")
    @ResponseBody
    public String apply(@RequestParam("name") String name, @RequestParam("course") String course, @RequestParam("purpose") List<Integer> purpose){
        System.out.println(name);
        System.out.println(course);
        for (Integer p : purpose) {
            System.out.println(p);
        }
        return "SUCCESS";
    }
}
