package org.simple.clinic.outpatient.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PasswordServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(PasswordServiceTest.class);

    private static final String PASSWORD_VALUE = "password";

    private final PasswordService passwordService;

    public PasswordServiceTest(@Autowired PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @BeforeAll
    static void setup() {
        System.setProperty("java.awt.headless", "false");
    }

    @Test
    void testGetHashedPassword() {
        String hashedPassword = passwordService.getHashedPassword(PASSWORD_VALUE);
        logger.info("hashedPassword = " + hashedPassword);
        Assertions.assertNotNull(hashedPassword);
    }

    @Test
    void testIsPasswordMatches() {
        String hashedPasswordDatabase = passwordService.getHashedPassword(PASSWORD_VALUE);
        logger.info("hashedPassword = " + hashedPasswordDatabase);

        Assertions.assertNotEquals(PASSWORD_VALUE, hashedPasswordDatabase);

        Assertions.assertTrue(passwordService.isPasswordMatches(PASSWORD_VALUE, hashedPasswordDatabase));
    }
}
