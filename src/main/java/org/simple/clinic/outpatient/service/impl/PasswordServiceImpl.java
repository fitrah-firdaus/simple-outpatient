package org.simple.clinic.outpatient.service.impl;

import org.simple.clinic.outpatient.service.PasswordService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl implements PasswordService {
    
    private final PasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     *
     * @param password
     * @return
     */
    @Override
    public String getHashedPassword(String password){
        return encoder.encode(password);
    }

    /**
     *
     * @param passwordInput
     * @param passwordDB
     * @return
     */
    @Override
    public boolean isPasswordMatches(String passwordInput, String passwordDB){
        return encoder.matches(passwordInput, passwordDB);
    }
}
