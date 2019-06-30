package com.mateacademy.springmvcexample.transform;

import com.mateacademy.springmvcexample.controller.dto.Student;
import com.mateacademy.springmvcexample.model.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface StudentMapper {
    StudentEntity mapStudentToStudentEntity(Student student);

    @Mapping(target = "id", source = "id")
    Student mapStudentEntityToStudent(StudentEntity studentEntity);

    List<Student> mapStudentEntityListToStudentList(List<StudentEntity> studentEntityList);
}
