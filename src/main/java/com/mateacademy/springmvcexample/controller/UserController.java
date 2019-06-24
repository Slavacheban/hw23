package com.mateacademy.springmvcexample.controller;


import com.mateacademy.springmvcexample.controller.dto.User;
import com.mateacademy.springmvcexample.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService service;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping(path = "/registration_form")
    public ModelAndView registrationForm() {
        User user = new User();
        ModelAndView modelAndView = new ModelAndView("registration_form");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping("/registration")
    public RedirectView userRegistration(@ModelAttribute("user") User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(user.getRole());
        service.createUser(user);
        return new RedirectView("/admin/users");
    }
}
