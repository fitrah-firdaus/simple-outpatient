/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.simple.clinic.outpatient.repository;

import java.util.List;
import org.simple.clinic.outpatient.model.Doctor;
import org.simple.clinic.outpatient.model.DoctorSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fef339
 */
@Repository
public interface DoctorSheduleRepository
    extends JpaRepository<DoctorSchedule,
        Integer>{
    
    List<DoctorSchedule> findByDoctorId
        (Doctor doctor);
}
