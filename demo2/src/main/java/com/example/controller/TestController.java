package com.example.controller;

import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

/**
 * @auth chenmingzhou
 */
@Controller
public class TestController {

    @PostConstruct
    public void init(){
        System.out.println("abc");
    }
}
