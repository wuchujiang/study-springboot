package com.study.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(HttpSession session) {
        Integer count = (Integer) session.getAttribute("count");
        if(null == count) {
            count = 0;
        }
        System.out.println(session.isNew());
        System.out.println(session.getId());
        count ++;
        session.setAttribute("count", count);

        return "计数" + count + "~~";
    }
}
