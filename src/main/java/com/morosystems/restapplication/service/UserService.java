package com.morosystems.restapplication.service;

import com.morosystems.restapplication.entity.UserEntity;
import com.morosystems.restapplication.exception.UserNotFoundException;
import com.morosystems.restapplication.repository.UserRepository;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;


@Component
public class UserService implements  IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserEntity getUserById(int id) {
        UserEntity userEntity;
        if (userRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException();
        }
        userEntity = userRepository.findById(id).get();
        return userEntity;
    }


    public List<UserEntity> getAllUsers() {
        return (List<UserEntity>) userRepository.findAll();
    }


    public void createUser(String name, UserEntity userEntity) {
        userRepository.save(userEntity);
    }


    public void updateUser(int id , UserEntity userEntity) {
        userRepository.save(userEntity);
    }


}
