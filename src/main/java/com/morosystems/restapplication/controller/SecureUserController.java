package com.morosystems.restapplication.controller;

import com.morosystems.restapplication.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/secure")
public class SecureUserController {

    private final UserService userService;

    public SecureUserController(UserService userService) {
        this.userService = userService;
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@Valid @PathVariable int id) {
        userService.deleteUser(id);
    }
}
