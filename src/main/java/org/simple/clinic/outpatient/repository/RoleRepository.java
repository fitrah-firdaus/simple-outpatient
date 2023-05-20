/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.simple.clinic.outpatient.repository;

import org.simple.clinic.outpatient.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fef339
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    
    @Query("select r from Role r join fetch r.permissionList join fetch "
            + "r.permissionList.menuId where r.roleId =?1 and r.isDeleted = ?2")
    Role findByIdWithPermission(Integer id, boolean isDeleted);
}
