package com.mateacademy.springmvcexample.controller;

import com.mateacademy.springmvcexample.dto.Student;
import com.mateacademy.springmvcexample.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentController {
    private StudentService studentService;

    @GetMapping(path = "/")
    public String index() {
        return "index";
    }

    @GetMapping(path = "/students/add")
    public String createUser(Model model) {
        model.addAttribute("user", new Student());
        return "edit";
    }

    @PostMapping(path = "students")
    public String saveUser(Student student) {
        studentService.createStudent(student);
        return "redirect:/students";
    }

    @GetMapping(path = "/students")
    public String getAllUsers(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students";
    }

    @GetMapping(path = "/students/edit/{id}")
    public String editUser(Model model, @PathVariable(value = "id") Long id) {
        model.addAttribute("student", studentService.findStudentById(id));
        return "edit";
    }

    @GetMapping(path = "/students/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id) {
        studentService.deleteStudent(id);
        return "redirect:/users";
    }
}
