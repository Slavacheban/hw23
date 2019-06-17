package com.mateacademy.springmvcexample.service;

import com.mateacademy.springmvcexample.dto.Student;

import java.util.List;

public interface StudentService {

    void createStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Long id);

    Student findStudentById(Long id);

    List<Student> findAll();
}
