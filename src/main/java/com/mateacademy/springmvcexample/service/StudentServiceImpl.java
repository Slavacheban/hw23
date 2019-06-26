package com.mateacademy.springmvcexample.service;

import com.mateacademy.springmvcexample.controller.dto.Student;
import com.mateacademy.springmvcexample.model.StudentEntity;
import com.mateacademy.springmvcexample.repository.StudentRepository;
import com.mateacademy.springmvcexample.transform.StudentMapper;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    private final StudentMapper mapper = Mappers.getMapper(StudentMapper.class);

    @Override
    public void createStudent(Student student) {
        repository.save(mapper.mapStudentToStudentEntity(student));
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Student findStudentById(Long id) {
        return mapper.mapStudentEntityToStudent(repository.findById(id).orElseThrow(RuntimeException::new));
    }

    @Override
    public List<Student> findAll() {
        return mapper.mapStudentEntityListToStudentList(repository.findAll());
    }
}
