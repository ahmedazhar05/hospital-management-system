package com.healthplus.processmanagement.model;

import java.io.Serializable;

public class MedicinePlan implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private Prescription prescription;
    private String name;
    private String dosage;
    private Integer duration = -1;

    public MedicinePlan() {
        super();
    }

    public MedicinePlan(Prescription prescription, String name, String dosage, Integer duration) {
        this.prescription = prescription;
        this.name = name;
        this.dosage = dosage;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "MedicinePlan [id=" + id + ", prescription=" + prescription + ", name=" + name + ", dosage=" + dosage + ", duration=" + duration + "]";
    }
}