package com.morosystems.restapplication.controller;

import com.morosystems.restapplication.entity.UserEntity;
import com.morosystems.restapplication.exception.UserNotFoundException;
import com.morosystems.restapplication.service.UserService;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public UserEntity getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users/")
    public void addUser(@RequestBody UserEntity userEntity, @PathVariable String name) {
        userService.createUser(name, userEntity);
    }

    @PutMapping("/users/{id}")
    public void updateUser(@RequestBody UserEntity userEntity, @PathVariable int id) {
        userService.updateUser(id, userEntity);
    }
}
