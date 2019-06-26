package com.mateacademy.springmvcexample.service;

import com.mateacademy.springmvcexample.controller.dto.Student;
import com.mateacademy.springmvcexample.model.StudentEntity;

import java.util.List;

public interface StudentService {

    void createStudent(Student student);

    void deleteStudent(Long id);

    Student findStudentById(Long id);

    List<Student> findAll();
}
