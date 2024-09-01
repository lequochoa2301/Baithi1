package com.example.bthi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelLoController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
