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

@Entity
public class Appointment implements Serializable {
    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message="Patient is required")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Patient patient;

    @NotNull(message="Date is required")
    private Date date;

    @NotNull(message="Doctor is required")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Doctor doctor;

    @NotNull(message="Timeslot is required")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Timeslot timeslot;

    private String symptom;

    public Appointment() {
        super();
    }

    public Appointment(Patient patient, Doctor doctor, Timeslot timeslot, String symptom) {
        this.patient = patient;
        this.doctor = doctor;
        this.timeslot = timeslot;
        this.symptom = symptom;
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

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

    @Override
    public String toString() {
        return "Appointment [id=" + id + ", patient=" + patient + ", doctor=" + doctor + ", timeslot=" + timeslot + ", symptom=" + symptom + "]";
    }
}