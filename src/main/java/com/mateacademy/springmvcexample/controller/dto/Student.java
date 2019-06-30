package com.mateacademy.springmvcexample.controller.dto;

import com.mateacademy.springmvcexample.model.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Student {
    private Long id;
    private UUID uuid;
    private String name;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 2;

        return prime * result + (name == null ? 0 : name.hashCode());
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof StudentEntity) {

            StudentEntity producerEntity = (StudentEntity) obj;

            if (name.equals(producerEntity.getName())) {
                return true;
            }
        }
        return false;
    }
}
