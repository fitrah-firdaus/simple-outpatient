/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.simple.clinic.outpatient.service.impl;

import java.util.Date;
import java.util.Optional;
import org.simple.clinic.outpatient.model.Doctor;
import org.simple.clinic.outpatient.repository.DoctorRepository;
import org.simple.clinic.outpatient.service.DoctorRegistrationService;
import org.springframework.stereotype.Service;

/**
 *
 * @author fef339
 */
@Service
public class DoctorRegistrationServiceImpl implements DoctorRegistrationService {

    public DoctorRegistrationServiceImpl(
            DoctorRepository 
                    doctorRepository) {
        this.doctorRepository = 
                doctorRepository;
    }

    private final DoctorRepository 
            doctorRepository;
    @Override
    public Optional<Doctor> findDoctorById(int id) {
        return doctorRepository.findById(id);
    }

    @Override
    public void updateDoctor(int doctorId, String doctorName, String doctorSpecialist) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void persistDoctor(Doctor doctor,
            String doctorName,
            String doctorSpecialist){
        if(doctor == null) {
            doctor = new Doctor();
        }
        doctor.setDoctorName(doctorName);
        doctor.setSpecialist(
                doctorSpecialist);
        doctor.setLastModified(new Date());
        if(doctor.getDateCreated() == null){
            doctor.setDateCreated(new Date());
        }
        doctorRepository.save(doctor);
    }
    
}
