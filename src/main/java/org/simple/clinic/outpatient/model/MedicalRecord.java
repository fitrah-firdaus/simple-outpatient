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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author fef339
 */
@Entity
@Table(name = "medical_record", catalog = "outpatient", schema = "")
@NamedQueries({
    @NamedQuery(name = "MedicalRecord.findAll", query = "SELECT m FROM MedicalRecord m")})
public class MedicalRecord extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "medical_record_id", nullable = false)
    private Integer medicalRecordId;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 65535)
    private String diagnose;
    @JoinColumn(name = "booking_id", referencedColumnName = "booking_id", nullable = false)
    @ManyToOne(optional = false)
    private Booking bookingId;
    @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id", nullable = false)
    @ManyToOne(optional = false)
    private Doctor doctorId;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id", nullable = false)
    @ManyToOne(optional = false)
    private Patient patientId;
    @JoinColumn(name = "recipe_id", referencedColumnName = "recipe_id", nullable = false)
    @ManyToOne(optional = false)
    private Recipe recipeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicalRecordId")
    private List<Recipe> recipeList;

    public MedicalRecord() {
    }

    public MedicalRecord(Integer medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }

    public MedicalRecord(Integer medicalRecordId, String diagnose, Date dateCreated, boolean isDeleted) {
        this.medicalRecordId = medicalRecordId;
        this.diagnose = diagnose;
        this.dateCreated = dateCreated;
        this.isDeleted = isDeleted;
    }

    public Integer getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(Integer medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public Booking getBookingId() {
        return bookingId;
    }

    public void setBookingId(Booking bookingId) {
        this.bookingId = bookingId;
    }

    public Doctor getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Doctor doctorId) {
        this.doctorId = doctorId;
    }

    public Patient getPatientId() {
        return patientId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    public Recipe getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Recipe recipeId) {
        this.recipeId = recipeId;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicalRecordId != null ? medicalRecordId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicalRecord)) {
            return false;
        }
        MedicalRecord other = (MedicalRecord) object;
        return !((this.medicalRecordId == null && other.medicalRecordId != null) || (this.medicalRecordId != null && !this.medicalRecordId.equals(other.medicalRecordId)));
    }

    @Override
    public String toString() {
        return "org.simple.clinic.outpatient.model.MedicalRecord[ medicalRecordId=" + medicalRecordId + " ]";
    }
    
}
