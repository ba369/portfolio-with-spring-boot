package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {

    // You write these three methods:
    @GetMapping("/project/1")
    public String project1() {
        // Your code here (only 1 line!)
    	return "project1";
    }

    @GetMapping("/project/2")
    public String project2() {
        // Your code here
    	return "project2";
    }

    @GetMapping("/project/3")
    public String project3() {
        // Your code here
    	return "project3";
    }
}