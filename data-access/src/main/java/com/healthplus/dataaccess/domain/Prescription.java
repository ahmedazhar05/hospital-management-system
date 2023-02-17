package com.healthplus.dataaccess.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

@Entity
public class Prescription{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @NotNull
    private Patient patient;

    @NotNull
    private Doctor doctor;

    @NotNull
    private String diagnosis;

    private String investigation;

    private String avoidables;

    @NotNull
    @FutureOrPresent
    private Date date;

    @NotNull
    private boolean isIpd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public boolean isIpd() {
		return isIpd;
	}

	public void setIpd(boolean isIpd) {
		this.isIpd = isIpd;
	}
}