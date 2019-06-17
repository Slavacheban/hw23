package com.mateacademy.springmvcexample.transform;

import com.mateacademy.springmvcexample.dto.Student;
import com.mateacademy.springmvcexample.model.StudentEntity;
import com.mateacademy.springmvcexample.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentTransformer {
    private final StudentRepository repository;

    public void addStudent(Student student) {
        repository.save(buildEntity(student));
    }

    public void updateStudent(Student student) {
        repository.save(buildEntity(student));
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    public List<Student> findAll() {
        List<StudentEntity> entities = repository.findAll();
        return buildUsers(entities);
    }

    public Student findOne(Long id) {
        return buildUser(repository.findById(id).orElseThrow(IllegalArgumentException::new));
    }

    private Student buildUser(StudentEntity entity) {
        return new Student()
                .setId(entity.getId())
                .setAge(entity.getAge())
                .setName(entity.getName())
                .setSalary(entity.getSalary())
                .setEmail(entity.getEmail());
    }

    private List<Student> buildUsers(List<StudentEntity> entities) {
        return entities.stream()
                .map(this::buildUser)
                .collect(toList());
    }

    private StudentEntity buildEntity(Student student) {
        StudentEntity entity;
        if(student.getId() == null) {
            entity = new StudentEntity();
        } else entity = repository.findById(student.getId()).orElseThrow(IllegalArgumentException::new);
        entity
                .setAge(student.getAge())
                .setName(student.getName())
                .setSalary(student.getSalary())
                .setEmail(student.getEmail());
        student.setId(entity.getId());
        return entity;
    }
}
