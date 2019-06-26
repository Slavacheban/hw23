package com.mateacademy.springmvcexample.controller;


import com.mateacademy.springmvcexample.controller.dto.User;
import com.mateacademy.springmvcexample.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService service;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping(path = "/registration-form")
    public ModelAndView registrationForm() {
        User user = new User();
        ModelAndView modelAndView = new ModelAndView("registration-form");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping("/registration")
    public RedirectView userRegistration(@ModelAttribute("user") User user){
        user.setPassword(user.getPassword());
        user.setRole(user.getRole());
        service.createUser(user);
        return new RedirectView("/admin/users");
    }

    @GetMapping("/admin/users")
    public ModelAndView allUsers(){
        ModelAndView modelAndView = new ModelAndView("ADMIN_users_list");
        modelAndView.addObject("users" , service.findAll());
        return modelAndView;
    }

    @GetMapping("/admin/edit-user/{id}")
    public ModelAndView editProductForm(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("ADMIN_edit_user");
        User user = service.findUserById(id);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @DeleteMapping("/admin/delete-user/{id}")
    public RedirectView deleteProduct(@PathVariable(name = "id") Long id){
        service.deleteUser(id);
        return new RedirectView("/admin/users");
    }

    @GetMapping("/user/users")
    public ModelAndView allUsersForUser() {
        ModelAndView modelAndView = new ModelAndView("USER_user_list");
        modelAndView.addObject("users", service.findAll());
        return modelAndView;
    }

}
