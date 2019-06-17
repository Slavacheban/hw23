package com.mateacademy.springmvcexample.controller;

import com.mateacademy.springmvcexample.dto.User;
import com.mateacademy.springmvcexample.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService service;

    @GetMapping(path = "/login")
    public String getLogin(User user) {
        return "login";
    }

    @PostMapping(path = "/login")
    public String getInfo(User user) {
        return "login";
    }
}
