package com.mateacademy.springmvcexample.service;

import com.mateacademy.springmvcexample.controller.dto.User;
import com.mateacademy.springmvcexample.model.user.UserEntity;
import com.mateacademy.springmvcexample.repository.UserRepository;
import com.mateacademy.springmvcexample.transform.UserMapper;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Override
    public void createUser(User user) {
        repository.save(mapper.mapUserToUserEntity(user));
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    public User findUserById(Long id) {
        return mapper.mapUserEntityToUser(repository.findById(id).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public List<User> findAll() {
        return mapper.mapUserEntityListToUserList(repository.findAll());
    }
}
