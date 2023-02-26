package com.healthplus.processmanagement.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class DietPlan implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long id;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Prescription prescription;
    private String food;
    private Integer duration;

    public DietPlan() {
        super();
    }

    public DietPlan(Prescription prescription, String food, Integer duration) {
        this.prescription = prescription;
        this.food = food;
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

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "DietPlan [id=" + id + ", prescription=" + prescription + ", food=" + food + ", duration=" + duration + "]";
    }
}