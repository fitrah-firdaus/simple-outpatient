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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author fef339
 */
@Entity
@Table(name = "doctor_schedule", catalog = "outpatient", schema = "")
@NamedQueries({
    @NamedQuery(name = "DoctorSchedule.findAll", query = "SELECT d FROM DoctorSchedule d")})
public class DoctorSchedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "doctor_schedule_id", nullable = false)
    private Integer doctorScheduleId;
    @Basic(optional = false)
    @Column(nullable = false, length = 30)
    private String day;
    @Basic(optional = false)
    @Column(name = "start_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Basic(optional = false)
    @Column(name = "end_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @Basic(optional = false)
    @Column(name = "date_created", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Basic(optional = false)
    @Column(name = "last_modified", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id", nullable = false)
    @ManyToOne(optional = false)
    private Doctor doctorId;

    public DoctorSchedule() {
    }

    public DoctorSchedule(Integer doctorScheduleId) {
        this.doctorScheduleId = doctorScheduleId;
    }

    public DoctorSchedule(Integer doctorScheduleId, String day, Date startTime, Date endTime, Date dateCreated, Date lastModified) {
        this.doctorScheduleId = doctorScheduleId;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dateCreated = dateCreated;
        this.lastModified = lastModified;
    }

    public Integer getDoctorScheduleId() {
        return doctorScheduleId;
    }

    public void setDoctorScheduleId(Integer doctorScheduleId) {
        this.doctorScheduleId = doctorScheduleId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Doctor getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Doctor doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doctorScheduleId != null ? doctorScheduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DoctorSchedule)) {
            return false;
        }
        DoctorSchedule other = (DoctorSchedule) object;
        if ((this.doctorScheduleId == null && other.doctorScheduleId != null) || (this.doctorScheduleId != null && !this.doctorScheduleId.equals(other.doctorScheduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.simple.clinic.outpatient.model.DoctorSchedule[ doctorScheduleId=" + doctorScheduleId + " ]";
    }
    
}
