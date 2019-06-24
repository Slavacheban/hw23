package com.mateacademy.springmvcexample.service;

import com.mateacademy.springmvcexample.model.StudentEntity;
import com.mateacademy.springmvcexample.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentServiceImpl implements StudentService {
    private StudentRepository repository;

    @Override
    public StudentEntity createStudent(StudentEntity student) {
        return repository.save(student);
    }

    @Override
    public void updateStudent(StudentEntity student) {
        repository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    @Override
    public StudentEntity findStudentById(Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<StudentEntity> findAll() {
        return repository.findAll();
    }
}
