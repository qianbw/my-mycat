package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mycat")
public class CommonController {

    @RequestMapping(value = "/")
    public String test2() {
        return "hello world!";
    }
}
