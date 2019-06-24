package com.mateacademy.springmvcexample.transform;

import com.mateacademy.springmvcexample.controller.dto.User;
import com.mateacademy.springmvcexample.model.user.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-06-22T17:59:09+0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity mapUserToUserEntity(User user) {
        if ( user == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( user.getId() );
        userEntity.setPassword( user.getPassword() );
        userEntity.setRole( user.getRole() );

        return userEntity;
    }

    @Override
    public User mapUserEntityToUser(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        User user = new User();

        user.setId( userEntity.getId() );
        user.setPassword( userEntity.getPassword() );
        user.setRole( userEntity.getRole() );

        return user;
    }

    @Override
    public List<User> mapUserEntityListToUserList(List<UserEntity> userEntities) {
        if ( userEntities == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userEntities.size() );
        for ( UserEntity userEntity : userEntities ) {
            list.add( mapUserEntityToUser( userEntity ) );
        }

        return list;
    }
}
