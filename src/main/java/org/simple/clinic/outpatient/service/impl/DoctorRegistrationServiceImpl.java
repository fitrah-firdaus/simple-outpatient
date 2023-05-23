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
import org.simple.clinic.outpatient.repository.DoctorScheduleRepository;
import org.simple.clinic.outpatient.service.DoctorRegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author fef339
 */
@Service
public class DoctorRegistrationServiceImpl implements DoctorRegistrationService {
    
    private static final Logger logger = LoggerFactory.getLogger(DoctorRegistrationServiceImpl.class);
    
    private final DoctorScheduleRepository 
            doctorScheduleRepository;

    public DoctorRegistrationServiceImpl(
            DoctorRepository doctorRepository,
            DoctorScheduleRepository doctorScheduleRepository) {
        this.doctorRepository = 
                doctorRepository;
        this.doctorScheduleRepository = doctorScheduleRepository;
    }

    private final DoctorRepository 
            doctorRepository;
    
    
    @Override
    public Doctor findDoctorById(int id) {
        return doctorRepository.findByIdWithDoctorSchedule(id);
    }

    @Override
    public void updateDoctor(int doctorId, String doctorName, String doctorSpecialist, List<DoctorSchedule> doctorScheduleList) {
        doctorRepository.findById(doctorId).ifPresentOrElse((Doctor doctor) -> {
            persistDoctor(doctor, doctorName, doctorSpecialist, doctorScheduleList);
        }, () -> {
            persistDoctor(null, doctorName, doctorSpecialist, doctorScheduleList);
        });
    }
    
    private void persistDoctor(Doctor doctor,
            String doctorName,
            String doctorSpecialist, List<DoctorSchedule> doctorScheduleList){
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
        logger.info("" + doctor);
        logger.info("" + doctorScheduleList);
        doctorRepository.save(doctor);
        
        if(doctorScheduleList != null && !doctorScheduleList.isEmpty()){
            logger.info("FIND Doctor Schedule based on Doctor ID " + doctor.getDoctorId());
            List<DoctorSchedule> doctorScheduleDB = doctorScheduleRepository.findByDoctorId(doctor);
            if(doctorScheduleDB != null && !doctorScheduleDB.isEmpty()){
                for (DoctorSchedule doctorSchedule : doctorScheduleDB) {
                    doctorScheduleRepository.delete(doctorSchedule);
                }
            }
            for (int i = 0; i < doctorScheduleList.size(); i++) {
                DoctorSchedule get = doctorScheduleList.get(i);
                get.setDoctorId(doctor);
                doctorScheduleRepository.save(get);
            }
        }
    }

    @Override
    public Doctor saveDoctor(String doctorName, String specialist, List<DoctorSchedule> doctorScheduleList) {
       Doctor doctor = new Doctor();
       doctor.setDoctorName(doctorName);
       doctor.setSpecialist(specialist);
       doctor.setDateCreated(new Date());
       doctor.setLastModified(new Date());
       doctor.setIsDeleted(false);
       doctor = doctorRepository.save(doctor);
        for (int i = 0; i < doctorScheduleList.size(); i++) {
            DoctorSchedule get = doctorScheduleList.get(i);
            get.setDoctorId(doctor);
            doctorScheduleRepository.save(get);
        }
       logger.info("" + doctor);
       logger.info(""+doctorScheduleList);
       return doctorRepository.save(doctor);
    }

    @Override
    public Doctor deleteDoctor(int id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        doctor.ifPresent((Doctor d) -> {
            d.setIsDeleted(true);
            doctorRepository.save(d);
        });
        return doctor.orElse(new Doctor());
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAllWithoutDeleted();
    }
    
}
