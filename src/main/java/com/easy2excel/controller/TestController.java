package com.easy2excel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String m1() {
        return "hii";
    }

    @PostMapping("/")
    public String saveData(){
        return "save";
    }
}
