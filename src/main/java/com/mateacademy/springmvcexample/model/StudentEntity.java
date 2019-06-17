package com.mateacademy.springmvcexample.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "students")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class StudentEntity extends DateEntity{

    private Integer age;
    private String name;
    private Integer salary;
    private String email;
}
