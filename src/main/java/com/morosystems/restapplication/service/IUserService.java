package com.morosystems.restapplication.service;

import com.morosystems.restapplication.entity.UserEntity;

import java.util.List;

public interface IUserService {

    UserEntity getUserById(int id);
    List<UserEntity> getAllUsers();
    void createUser(UserEntity userEntity);
    void updateUser(int id, UserEntity userEntity);
    void deleteUser(int id);
}
