package com.morosystems.restapplication.controller;

import com.morosystems.restapplication.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void getUserById() throws Exception {

//        MvcResult result = mockMvc.perform(get("/users")).andReturn();
//        String actualContentType = result.getResponse().getContentType();
//        String expectedContentType = MediaType.APPLICATION_JSON_VALUE;
//
//
//        mockMvc.perform(get("/users")).andExpect(status().isOk());


    }

    @Test
    void getAllUsers() {
    }

    @Test
    void addUser() {
    }

    @Test
    void updateUser() {
    }
}