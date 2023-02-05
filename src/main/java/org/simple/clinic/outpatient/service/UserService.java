/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.simple.clinic.outpatient.service;

import org.simple.clinic.outpatient.model.User;

/**
 *
 * @author fef339
 */
public interface UserService {
    
    User login(String userName, String password);
    
    User logout(String userName);
}
