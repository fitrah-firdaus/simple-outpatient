/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.simple.clinic.outpatient.service;

import java.util.List;
import org.simple.clinic.outpatient.model.Doctor;
import org.simple.clinic.outpatient.model.DoctorSchedule;

/**
 *
 * @author fef339
 */
public interface DoctorRegistrationService {
    Doctor saveDoctor(String doctorName, String specialist, List<DoctorSchedule> doctorScheduleList);
    
    Doctor findDoctorById(int id);
    
    Doctor deleteDoctor(int id);
    
    List<Doctor> findAll();
    
    void updateDoctor(int doctorId,
            String doctorName,
            String doctorSpecialist,
            List<DoctorSchedule> doctorScheduleList);
}
