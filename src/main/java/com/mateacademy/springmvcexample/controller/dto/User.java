package com.mateacademy.springmvcexample.controller.dto;

import com.mateacademy.springmvcexample.model.user.Role;
import com.mateacademy.springmvcexample.model.user.UserEntity;
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
public class User {
    private Long id;
    private UUID uuid;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Role role;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 2;

        return prime * result + (email == null ? 0 : email.hashCode());
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof UserEntity) {

            UserEntity userEntity = (UserEntity) obj;

            if (this.email.equals(userEntity.getLogin()) &&
                    this.password.equals(userEntity.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
