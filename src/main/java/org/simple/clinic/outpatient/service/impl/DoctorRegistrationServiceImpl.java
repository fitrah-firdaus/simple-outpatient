/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.simple.clinic.outpatient.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.simple.clinic.outpatient.model.Doctor;
import org.simple.clinic.outpatient.model.DoctorSchedule;
import org.simple.clinic.outpatient.repository.DoctorRepository;
import org.simple.clinic.outpatient.repository.DoctorSheduleRepository;
import org.simple.clinic.outpatient.service.DoctorRegistrationService;
import org.springframework.stereotype.Service;

/**
 *
 * @author fef339
 */
@Service
public class DoctorRegistrationServiceImpl implements DoctorRegistrationService {

    public DoctorRegistrationServiceImpl(
            DoctorRepository doctorRepository
            , DoctorSheduleRepository 
                    doctorScheduleRepository) {
        this.doctorRepository = 
                doctorRepository;
        this.doctorScheduleRepository = 
                doctorScheduleRepository;
    }

    private final DoctorRepository 
            doctorRepository;
    private final DoctorSheduleRepository
            doctorScheduleRepository;
    @Override
    public Doctor findDoctorById(int id) {
        return doctorRepository
                .findByIdWithDoctorSchedule(id);
    }

    
    private void persistDoctor(Doctor doctor,
            String doctorName,
            String doctorSpecialist,
            List<DoctorSchedule> 
                    doctorScheduleList){
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

    @Override
    public void updateDoctor(int doctorId, String doctorName, String doctorSpecialist, List<DoctorSchedule> doctorScheduleList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Doctor saveDoctor(String doctorName, String specialist, List<DoctorSchedule> doctorScheduleList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Doctor deleteDoctor(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Doctor> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
