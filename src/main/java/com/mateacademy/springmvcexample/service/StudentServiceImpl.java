package com.mateacademy.springmvcexample.service;

import com.mateacademy.springmvcexample.dto.Student;
import com.mateacademy.springmvcexample.transform.StudentTransformer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentServiceImpl implements StudentService {
    private StudentTransformer transformer;

    @Override
    public void createStudent(Student student) {
        transformer.addStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        transformer.updateStudent(student);
    }

    @Override
    public void deleteStudent(Long id) {
        transformer.deleteStudent(id);
    }

    @Override
    public Student findStudentById(Long id) {
        return transformer.findOne(id);
    }

    @Override
    public List<Student> findAll() {
        return transformer.findAll();
    }
}
