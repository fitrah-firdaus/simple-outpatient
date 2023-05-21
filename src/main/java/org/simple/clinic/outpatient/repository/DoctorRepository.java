/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.simple.clinic.outpatient.repository;

import org.simple.clinic.outpatient.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fef339
 */
@Repository
public interface DoctorRepository extends
        JpaRepository<Doctor, Integer>{
    
    @Query("select d from Doctor d join fetch d.doctorScheduleList where d.doctorId = ?1")
    Doctor findByIdWithDoctorSchedule(Integer id);
}
