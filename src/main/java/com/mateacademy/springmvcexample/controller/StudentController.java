package com.mateacademy.springmvcexample.controller;

import com.mateacademy.springmvcexample.controller.dto.Student;
import com.mateacademy.springmvcexample.model.StudentEntity;
import com.mateacademy.springmvcexample.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path = "/students")
public class StudentController {
    private StudentService studentService;

    @GetMapping(path = "/add")
    public String createUser(Model model) {
        model.addAttribute("user", new Student());
        return "edit";
    }

    @PostMapping
    public String saveStudent(StudentEntity studentEntity) {
        studentService.createStudent(studentEntity);
        return "redirect:/students";
    }

    @GetMapping(path = "")
    public String getAllUsers(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students";
    }

    @GetMapping(path = "/edit/{id}")
    public String editUser(Model model, @PathVariable(value = "id") Long id) {
        model.addAttribute("student", studentService.findStudentById(id));
        return "edit";
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id) {
        studentService.deleteStudent(id);
        return "redirect:/users";
    }
}
