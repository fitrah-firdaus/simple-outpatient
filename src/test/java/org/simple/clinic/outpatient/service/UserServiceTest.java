/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.simple.clinic.outpatient.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;
import org.simple.clinic.outpatient.model.User;
import org.simple.clinic.outpatient.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 *
 * @author fef339
 */
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class UserServiceTest {

    private final PasswordService passwordService;
    private final UserService userService;

    @MockBean
    private UserRepository userRepository;

    public UserServiceTest(@Autowired PasswordService passwordService,
            @Autowired UserService userService) {
        this.passwordService = passwordService;
        this.userService = userService;
    }

    private static final String PASSWORD_VALUE = "password";
    private static final String BI_USER_NAME = "BI";
    private static final String WRONG_PASSWORD_VALUE = "wrong_password";

    @BeforeAll
    public void setup() {
        System.setProperty("java.awt.headless", "false");

        User biUser = new User();
        biUser.setUsername(BI_USER_NAME);
        biUser.setPassword(passwordService.getHashedPassword(PASSWORD_VALUE));

        Mockito.when(userRepository.findByUsernameAndIsDeleted(BI_USER_NAME)).thenReturn(biUser);
    }

    @Test
    void testLogin() {
        Assertions.assertNotNull(userService.login(BI_USER_NAME, PASSWORD_VALUE));
        Assertions.assertNull(userService.login(BI_USER_NAME, WRONG_PASSWORD_VALUE));
    }

}
