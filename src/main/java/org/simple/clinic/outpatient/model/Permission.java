/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.simple.clinic.outpatient.model;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 *
 * @author fef339
 */
@Entity
@Table(catalog = "outpatient", schema = "")
@NamedQueries({
    @NamedQuery(name = "Permission.findAll", query = "SELECT p FROM Permission p")})
public class Permission extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "permission_id", nullable = false)
    private Integer permissionId;
    @JoinColumn(name = "menu_id", referencedColumnName = "menu_id", nullable = false)
    @ManyToOne(optional = false)
    private Menu menuId;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
    @ManyToOne(optional = false)
    private Role roleId;

    public Permission() {
    }

    public Permission(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Permission(Integer permissionId, Date dateCreated, boolean isDeleted) {
        this.permissionId = permissionId;
        this.dateCreated = dateCreated;
        this.isDeleted = isDeleted;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Menu getMenuId() {
        return menuId;
    }

    public void setMenuId(Menu menuId) {
        this.menuId = menuId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permissionId != null ? permissionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Permission)) {
            return false;
        }
        Permission other = (Permission) object;
        return !((this.permissionId == null && other.permissionId != null) || (this.permissionId != null && !this.permissionId.equals(other.permissionId)));
    }

    @Override
    public String toString() {
        return "org.simple.clinic.outpatient.model.Permission[ permissionId=" + permissionId + " ]";
    }
    
}
