package com.healthplus.dataaccess.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class DietPlan implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Prescription is required")
    @ManyToOne(optional=false)
    private Prescription prescription;

    @NotNull(message = "Diet plan food is required")
    private String food;
    
    @Min(value = 0, message = "Duration cannot be negative")
    private Integer duration;

    public DietPlan() {
        super();
    }

    public DietPlan(@NotNull Prescription prescription, @NotNull String food, @Positive Integer duration) {
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