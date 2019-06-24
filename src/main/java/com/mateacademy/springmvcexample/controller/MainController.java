package com.mateacademy.springmvcexample.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {
    @GetMapping(path = "/")
    public String index() {
        return "index";
    }


}
