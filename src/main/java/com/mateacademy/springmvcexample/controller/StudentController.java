package com.mateacademy.springmvcexample.controller;

import com.mateacademy.springmvcexample.controller.dto.Student;
import com.mateacademy.springmvcexample.model.StudentEntity;
import com.mateacademy.springmvcexample.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentController {
    private StudentService studentService;

    @GetMapping("/admin/students")
    public ModelAndView getAllProducers(){
        ModelAndView modelAndView = new ModelAndView("ADMIN_student_list");
        modelAndView.addObject("students", studentService.findAll());
        return modelAndView;
    }

    @GetMapping("/admin/student-form")
    public ModelAndView producerForm(){
        Student student = new Student();
        ModelAndView modelAndView = new ModelAndView("ADMIN_student_form");
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @PostMapping("/admin/save-student")
    public RedirectView saveProducer(@ModelAttribute("student") Student student){
        studentService.createStudent(student);
        return new RedirectView("/admin/students");
    }

    @GetMapping("/admin/edit-student/{id}")
    public ModelAndView editProductForm(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("ADMIN_edit_student");
        Student student = studentService.findStudentById(id);
        modelAndView.addObject("student", student);

        return modelAndView;
    }

    @GetMapping("/admin/delete-student/{id}")
    public RedirectView deleteProducer(@PathVariable(name = "id") Long id){
        studentService.deleteStudent(id);
        return new RedirectView("/admin/students");
    }

    @GetMapping("user/students")
    public ModelAndView getAllProducersForUser(){
        ModelAndView modelAndView = new ModelAndView("USER_student_list");
        modelAndView.addObject("students", studentService.findAll());
        return modelAndView;
    }
}
