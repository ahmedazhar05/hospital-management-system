package com.healthplus.processmanagement.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Prescription implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Patient patient;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Doctor doctor;
    private String diagnosis;
    private String investigation;
    private String avoidables;
    private Date date;    
    private Boolean isIpd;

    public Prescription() {
        super();
    }

    public Prescription(Patient patient, Doctor doctor, String diagnosis, String investigation, String avoidables, Date date, Boolean isIpd) {
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