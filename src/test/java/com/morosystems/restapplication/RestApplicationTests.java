package com.morosystems.restapplication;

import com.morosystems.restapplication.controller.SecureUserController;
import com.morosystems.restapplication.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestApplicationTests {

    @Autowired
    private UserController userController;

    @Autowired
    private SecureUserController secureUserController;

    @Test
    void contextLoads() throws Exception{
        assertThat(userController).isNotNull();
        assertThat(secureUserController).isNotNull();
    }

}
