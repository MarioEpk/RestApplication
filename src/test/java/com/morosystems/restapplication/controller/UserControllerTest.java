package com.morosystems.restapplication.controller;

import com.morosystems.restapplication.entity.UserEntity;
import com.morosystems.restapplication.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Arrays;
import static org.hamcrest.Matchers.hasSize;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void testGetUserById() throws Exception {

        String URI = "/users/{id}";
        UserEntity user = new UserEntity();
        user.setName("user1");
        user.setId(1);

        Mockito.when(userService.getUserById(1)).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders.get(URI, user.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testGetAllUsers() throws Exception {

        String URI = "/users";
        UserEntity user1 = new UserEntity();
        user1.setName("user1");
        UserEntity user2 = new UserEntity();
        user2.setName("user2");

        Mockito.when(userService.getAllUsers()).thenReturn(Arrays.asList(user1, user2));
        mockMvc.perform(MockMvcRequestBuilders.get(URI)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));
    }

    @Test
    void testAddUserWithoutJson() throws Exception {
        String URI = "/users";
        UserEntity user = new UserEntity();
        user.setName("user");
        user.setId(1);

        Mockito.when(userService.createUser(user)).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.post(URI)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void testUpdateUserWithoutJson() throws Exception {
        String URI = "/users/{id}";
        UserEntity user = new UserEntity();
        user.setName("user");
        user.setId(1);

        Mockito.when(userService.updateUser(user.getId(), user)).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.put(URI, user.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}