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
    public String saveData() {
        return "save";
    }
    @GetMapping("/tets2")
    public String m2() {
        return "22222";
    }
}
