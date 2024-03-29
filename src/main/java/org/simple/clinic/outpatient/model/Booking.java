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
@Table(catalog = "outpatient", schema = "")
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b")})
public class Booking extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "booking_id", nullable = false)
    private Integer bookingId;
    @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id", nullable = false)
    @ManyToOne(optional = false)
    private Doctor doctorId;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id", nullable = false)
    @ManyToOne(optional = false)
    private Patient patientId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookingId")
    private List<MedicalRecord> medicalRecordList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookingId")
    private List<Payment> paymentList;

    public Booking() {
    }

    public Booking(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Booking(Integer bookingId, Date dateCreated, boolean isDeleted) {
        this.bookingId = bookingId;
        this.dateCreated = dateCreated;
        this.isDeleted = isDeleted;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
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

    public List<MedicalRecord> getMedicalRecordList() {
        return medicalRecordList;
    }

    public void setMedicalRecordList(List<MedicalRecord> medicalRecordList) {
        this.medicalRecordList = medicalRecordList;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingId != null ? bookingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        return !((this.bookingId == null && other.bookingId != null) || (this.bookingId != null && !this.bookingId.equals(other.bookingId)));
    }

    @Override
    public String toString() {
        return "org.simple.clinic.outpatient.model.Booking[ bookingId=" + bookingId + " ]";
    }
    
}
