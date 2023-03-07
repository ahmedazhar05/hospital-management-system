package com.healthplus.dataaccess.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
public class Prescription implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull(message="Patient is required")
    @ManyToOne(optional=false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Patient patient;

    @NotNull(message="Doctor is required")
    @ManyToOne(optional=false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Doctor doctor;

    @NotNull(message="Diagnosis is required")
    private String diagnosis;

    private String investigation;

    private String avoidables;

    @NotNull(message="Date is required")
    @PastOrPresent(message="Date cannot be in the past")
    private Date date;

    @NotNull(message="Whether prescription is for IPD or not should be mentioned")
    private Boolean isIpd;

    public Prescription() {
        super();
    }

    public Prescription(@NotNull Patient patient, @NotNull Doctor doctor, @NotNull String diagnosis, String investigation, String avoidables, @NotNull @PastOrPresent Date date, @NotNull Boolean isIpd) {
        this.patient = patient;
        this.doctor = doctor;
        this.diagnosis = diagnosis;
        this.investigation = investigation;
        this.avoidables = avoidables;
        this.date = date;
        this.isIpd = isIpd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getInvestigation() {
        return investigation;
    }

    public void setInvestigation(String investigation) {
        this.investigation = investigation;
    }

    public String getAvoidables() {
        return avoidables;
    }

    public void setAvoidables(String avoidables) {
        this.avoidables = avoidables;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getIsIpd() {
        return isIpd;
    }

    public void setIsIpd(Boolean isIpd) {
        this.isIpd = isIpd;
    }

    @Override
    public String toString() {
        return "Prescription [id=" + id + ", patient=" + patient + ", doctor=" + doctor + ", diagnosis=" + diagnosis + ", investigation=" + investigation + ", avoidables=" + avoidables + ", date=" + date + ", isIpd=" + isIpd + "]";
    }
}