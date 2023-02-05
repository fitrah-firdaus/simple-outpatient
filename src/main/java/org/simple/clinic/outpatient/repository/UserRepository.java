/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.simple.clinic.outpatient.repository;

import org.simple.clinic.outpatient.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fef339
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
 
    @Query("select u from User u join fetch u.roleId where u.username = ?1 and u.isDeleted = ?2")
    User findByUsernameAndIsDeleted(String userName, boolean deleted);
}
