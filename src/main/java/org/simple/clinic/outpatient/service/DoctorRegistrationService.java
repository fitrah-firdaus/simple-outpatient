/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.simple.clinic.outpatient.service;

import java.util.Optional;
import org.simple.clinic.outpatient.model.Doctor;

/**
 *
 * @author fef339
 */
public interface DoctorRegistrationService {
    Optional<Doctor> findDoctorById(int id);
    
    void updateDoctor(int doctorId,
            String doctorName,
            String doctorSpecialist);
}
