package com.mateacademy.springmvcexample.transform;

import com.mateacademy.springmvcexample.dto.User;
import com.mateacademy.springmvcexample.model.user.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class UserTransformer {
    public User buildUser(UserEntity entity) {
        return new User()
                .setId(entity.getId())
                .setLogin(entity.getLogin())
                .setPassword(entity.getPassword())
                .setOnline(entity.getOnline())
                .setRole(entity.getRole());
    }

    public List<User> buildUsers(List<UserEntity> entities) {
        return entities.stream()
                .map(this::buildUser)
                .collect(toList());
    }

    public UserEntity buildUserEntity(User user) {
        return (UserEntity) new UserEntity()
                .setId(user.getId())
                .setLogin(user.getLogin())
                .setPassword(user.getPassword())
                .setRole(user.getRole()).setId(user.getId());
    }
}
