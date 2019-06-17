package com.mateacademy.springmvcexample.dto;

import com.mateacademy.springmvcexample.model.user.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Setter
@Getter
@Accessors(chain = true)
public class User {
    private Long id;

    @Size(min = 2)
    @NotNull
    private String login;

    @NotNull
    private String password;

    private Role role;

    private Boolean online;
}
