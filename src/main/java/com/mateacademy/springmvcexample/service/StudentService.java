package com.mateacademy.springmvcexample.service;

import com.mateacademy.springmvcexample.model.StudentEntity;

import java.util.List;

public interface StudentService {

    StudentEntity createStudent(StudentEntity student);

    void updateStudent(StudentEntity student);

    void deleteStudent(Long id);

    StudentEntity findStudentById(Long id);

    List<StudentEntity> findAll();
}
