/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.simple.clinic.outpatient.service.impl;

import java.util.Date;
import java.util.Optional;
import org.simple.clinic.outpatient.model.Patient;
import org.simple.clinic.outpatient.repository.PatientRepository;
import org.simple.clinic.outpatient.service.RegistrationService;
import org.springframework.stereotype.Service;

/**
 *
 * @author fef339
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {

    public RegistrationServiceImpl(
            PatientRepository patientRepository) {
        this.patientRepository = 
                patientRepository;
    }

    private final PatientRepository 
            patientRepository;

    @Override
    public Patient savePatient(String name, 
            Date birthDate, String address) {
        Patient patient = new Patient();
        patient.setPatientName(name);
        patient.setBirthDate(birthDate);
        patient.setAddress(address);
        patient.setDateCreated(new Date());
        patient.setLastModified(new Date());

        return patientRepository.save(
                patient);
    }

    @Override
    public Optional<Patient> findPatientById(
            int id) {
        return patientRepository.findById(id);
    }

    @Override
    public void updatePatient(int id, 
            String name, Date birthDate, 
            String address) {
        patientRepository.findById(id).
                ifPresentOrElse((Patient 
                        patient) -> {
            persistPatient(patient, 
                    name, birthDate, address);
        }, () -> {
            persistPatient(
                    null, name, 
                    birthDate, address);
        });
    }

    private void persistPatient(Patient 
            patient, String name, 
            Date birthDate, String address) {
        if(patient == null){
            patient = new Patient();
        }
        patient.setPatientName(
                name);
        patient.setBirthDate(birthDate);
        patient.setAddress(address);
        patient.setLastModified(new Date());
        if(patient.getDateCreated() == null){
            patient.setDateCreated(new Date());
        }
        patientRepository.save(patient);
    }

}
