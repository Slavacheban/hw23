package com.mateacademy.springmvcexample.service;

import com.mateacademy.springmvcexample.controller.dto.User;
import com.mateacademy.springmvcexample.model.user.UserEntity;

import java.util.List;

public interface UserService {
    void createUser(User user);

    void deleteUser(Long id);

    User findUserById(Long id);

    List<User> findAll();
}
