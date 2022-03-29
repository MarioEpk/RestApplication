package com.morosystems.restapplication.service;

import com.morosystems.restapplication.entity.UserEntity;
import com.morosystems.restapplication.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity getUserById(int id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        UserEntity userEntity = optionalUserEntity.get();
//        if (userEntity != null) {
//            return userEntity;
//        }
//        throw new IllegalArgumentException();
        return userEntity;
    }
}
