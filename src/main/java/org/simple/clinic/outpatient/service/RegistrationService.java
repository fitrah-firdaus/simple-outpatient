/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.simple.clinic.outpatient.service;

import java.util.Date;
import java.util.Optional;
import org.simple.clinic.outpatient.model.Patient;

/**
 *
 * @author fef339
 */
public interface RegistrationService {
    Patient savePatient(String name, 
            Date birthDate, String address);
    
    Optional<Patient> findPatientById(int id);
    
    void updatePatient(int id, 
            String name, Date birthDate,
            String address);
}
