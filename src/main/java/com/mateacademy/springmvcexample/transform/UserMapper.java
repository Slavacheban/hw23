package com.mateacademy.springmvcexample.transform;

import com.mateacademy.springmvcexample.controller.dto.User;
import com.mateacademy.springmvcexample.model.user.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface UserMapper {
    UserEntity mapUserToUserEntity(User user);

    @Mapping(target = "id", source = "id")
    User mapUserEntityToUser(UserEntity userEntity);

    List<User> mapUserEntityListToUserList(List<UserEntity> userEntities);
}
