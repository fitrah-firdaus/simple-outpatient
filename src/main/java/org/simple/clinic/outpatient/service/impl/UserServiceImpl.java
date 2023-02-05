/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.simple.clinic.outpatient.service.impl;

import org.simple.clinic.outpatient.model.Role;
import org.simple.clinic.outpatient.model.User;
import org.simple.clinic.outpatient.repository.RoleRepository;
import org.simple.clinic.outpatient.repository.UserRepository;
import org.simple.clinic.outpatient.service.PasswordService;
import org.simple.clinic.outpatient.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author fef339
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordService passwordService;

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository,
            PasswordService passwordService,
            RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
        this.roleRepository = roleRepository;
    }

    @Override
    public User login(String userName, String password) {
        User user = userRepository.findByUsernameAndIsDeleted(userName, false);
        if (user != null && passwordService.isPasswordMatches(password, user.getPassword())) {
            logger.info("User {} is success login", user.getUsername());
            if (user.getRoleId() != null) {
                Role roleWithPermissions = roleRepository.findByIdWithPermission(user.getRoleId().getRoleId(), false);
                if (roleWithPermissions != null) {
                    user.setRoleId(roleWithPermissions);
                }
            }
            return user;
        }
        return null;
    }

    @Override
    public User logout(String userName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
