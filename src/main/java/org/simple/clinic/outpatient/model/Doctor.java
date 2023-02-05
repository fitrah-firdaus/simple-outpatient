/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.simple.clinic.outpatient.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author fef339
 */
@Entity
@Table(catalog = "outpatient", schema = "")
@NamedQueries({
    @NamedQuery(name = "Doctor.findAll", query = "SELECT d FROM Doctor d")})
public class Doctor extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "doctor_id", nullable = false)
    private Integer doctorId;
    @Basic(optional = false)
    @Column(name = "doctor_name", nullable = false, length = 50)
    private String doctorName;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String specialist;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctorId")
    private List<Booking> bookingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctorId")
    private List<MedicalRecord> medicalRecordList;

    public Doctor() {
    }

    public Doctor(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Doctor(Integer doctorId, String doctorName, String specialist, Date dateCreated, boolean isDeleted) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.specialist = specialist;
        this.dateCreated = dateCreated;
        this.isDeleted = isDeleted;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public List<MedicalRecord> getMedicalRecordList() {
        return medicalRecordList;
    }

    public void setMedicalRecordList(List<MedicalRecord> medicalRecordList) {
        this.medicalRecordList = medicalRecordList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doctorId != null ? doctorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Doctor)) {
            return false;
        }
        Doctor other = (Doctor) object;
        return !((this.doctorId == null && other.doctorId != null) || (this.doctorId != null && !this.doctorId.equals(other.doctorId)));
    }

    @Override
    public String toString() {
        return "org.simple.clinic.outpatient.model.Doctor[ doctorId=" + doctorId + " ]";
    }
    
}
