package com.mateacademy.springmvcexample.transform;

import com.mateacademy.springmvcexample.controller.dto.Student;
import com.mateacademy.springmvcexample.model.StudentEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-06-22T17:59:10+0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentEntity mapStudentToStudentEntity(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setId( student.getId() );
        studentEntity.setName( student.getName() );

        return studentEntity;
    }

    @Override
    public Student mapStudentEntityToStudent(StudentEntity studentEntity) {
        if ( studentEntity == null ) {
            return null;
        }

        Student student = new Student();

        student.setId( studentEntity.getId() );
        student.setName( studentEntity.getName() );

        return student;
    }

    @Override
    public List<Student> mapStudentEntityListToStudentList(List<StudentEntity> studentEntityList) {
        if ( studentEntityList == null ) {
            return null;
        }

        List<Student> list = new ArrayList<Student>( studentEntityList.size() );
        for ( StudentEntity studentEntity : studentEntityList ) {
            list.add( mapStudentEntityToStudent( studentEntity ) );
        }

        return list;
    }
}
