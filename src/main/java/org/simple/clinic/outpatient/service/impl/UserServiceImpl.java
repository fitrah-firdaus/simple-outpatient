/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.simple.clinic.outpatient.service.impl;

import org.simple.clinic.outpatient.model.User;
import org.simple.clinic.outpatient.repository.UserRepository;
import org.simple.clinic.outpatient.service.PasswordService;
import org.simple.clinic.outpatient.service.UserService;
import org.springframework.stereotype.Service;

/**
 *
 * @author fef339
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordService passwordService;

    public UserServiceImpl(UserRepository userRepository,
            PasswordService passwordService) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
    }

    @Override
    public User login(String userName, String password) {
        User user = userRepository.findByUsernameAndIsDeleted(userName, false);
        if (user != null && passwordService.isPasswordMatches(password, user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public User logout(String userName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
