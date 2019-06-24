package com.mateacademy.springmvcexample.service;

import com.mateacademy.springmvcexample.controller.dto.User;
import com.mateacademy.springmvcexample.model.user.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity createUser(User user);

    void deleteUser(Long id);

    UserEntity findUserById(Long id);

    List<UserEntity> findAll();
}
