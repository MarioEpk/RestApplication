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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class SecureUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    @WithMockUser(username="Epack", password = "1234")
    void testDeleteUser() throws Exception {
        String URI = "/secure/users/{id}";
        UserEntity user = new UserEntity();
        user.setName("user");
        user.setId(1);
        String userWasDeleted = "User with id " + user.getId() +"was deleted.";

        Mockito.when(userService.deleteUser(user.getId())).thenReturn(userWasDeleted);

        mockMvc.perform(MockMvcRequestBuilders.delete(URI, user.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @WithMockUser(username="Epack", password = "1234")
    void testGetAllUsers() throws Exception {
        String URI = "/secure/users";
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
}