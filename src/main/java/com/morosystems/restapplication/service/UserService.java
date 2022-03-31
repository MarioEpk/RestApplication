package com.morosystems.restapplication.service;

import com.morosystems.restapplication.entity.UserEntity;
import com.morosystems.restapplication.exception.UserNotFoundException;
import com.morosystems.restapplication.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService implements  IUserService, UserDetailsService {

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
        return userRepository.findAll();
    }


    public void createUser(UserEntity userEntity) {

        userRepository.save(userEntity);
    }


    public UserEntity updateUser(int id, UserEntity newUserEntity) {

        if (userRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException(USER_NOT_FOUND);
        }
        Optional<UserEntity> optUserEntity = userRepository.findById(id);
        UserEntity userEntity = optUserEntity.get();
        userEntity.setName(newUserEntity.getName());
        userRepository.save(userEntity);
        return userEntity;
    }


    public void deleteUser(int id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException(USER_NOT_FOUND);
        }
        userRepository.deleteById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            throw new UserNotFoundException("User with provided name was not found");
        }
        return new UserDetailsImpl(userEntity);
    }
}
