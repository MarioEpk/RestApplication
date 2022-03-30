package com.morosystems.restapplication.service;

import com.morosystems.restapplication.entity.UserEntity;
import com.morosystems.restapplication.exception.UserNotFoundException;
import com.morosystems.restapplication.repository.UserRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;


@Component
public class UserService implements  IUserService {

    private final UserRepository userRepository;
    private final String USER_NOT_FOUND = "User with provided id was not found.";

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserEntity getUserById(int id) {
        UserEntity userEntity;
        if (userRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException(USER_NOT_FOUND);
        }
        userEntity = userRepository.findById(id).get();
        return userEntity;
    }


    public List<UserEntity> getAllUsers() {
        return (List<UserEntity>) userRepository.findAll();
    }


    public void createUser(UserEntity userEntity) {

        userRepository.save(userEntity);
    }


    public void updateUser(int id , UserEntity newUserEntity) {

        if (userRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException(USER_NOT_FOUND);
        }
        Optional<UserEntity> optUserEntity = userRepository.findById(id);
        UserEntity userEntity = optUserEntity.get();
        userEntity.setName(newUserEntity.getName());
        userRepository.save(newUserEntity);
    }


}
