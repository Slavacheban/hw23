package com.mateacademy.springmvcexample.service;

import com.mateacademy.springmvcexample.dto.User;
import com.mateacademy.springmvcexample.exceptions.UserNotFoundException;
import com.mateacademy.springmvcexample.model.user.UserEntity;
import com.mateacademy.springmvcexample.repository.UserRepository;
import com.mateacademy.springmvcexample.transform.UserTransformer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
    private final UserTransformer transformer;
    private final UserRepository repository;

    @Override
    public void createUser(User user) {
        repository.save(transformer.buildUserEntity(user));
    }

    @Override
    public void updateUser(User user) {
        repository.save(transformer.buildUserEntity(user));
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    public User findUserById(Long id) {
        return transformer.buildUser(repository.findById(id).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public List<User> findAll() {
        return transformer.buildUsers(repository.findAll());
    }
}
