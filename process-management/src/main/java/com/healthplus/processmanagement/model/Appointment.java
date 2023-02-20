package com.healthplus.processmanagement.model;

import java.io.Serializable;

public class Appointment implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Patient patient;
    private Doctor doctor;
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

    @Override
    public String toString() {
        return "Appointment [id=" + id + ", patient=" + patient + ", doctor=" + doctor + ", timeslot=" + timeslot + ", symptom=" + symptom + "]";
    }
}