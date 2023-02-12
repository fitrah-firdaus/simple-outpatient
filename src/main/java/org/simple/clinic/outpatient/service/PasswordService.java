package org.simple.clinic.outpatient.service;

public interface PasswordService {
   
    String getHashedPassword(String password);

    boolean isPasswordMatches(String passwordInput, String passwordDB);
}
