package com.morosystems.restapplication.service;

import com.morosystems.restapplication.entity.UserEntity;

import java.util.List;

public interface IUserService {

    UserEntity getUserById(int id);
    List<UserEntity> getAllUsers();
    UserEntity createUser(UserEntity userEntity);
    UserEntity updateUser(int id, UserEntity userEntity);
    String deleteUser(int id);
}
