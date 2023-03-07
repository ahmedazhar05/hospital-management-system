package com.healthplus.dataaccess.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class OccupiedBed implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull(message="Bed is required")
    @ManyToOne(optional=false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Bed bed;

    @NotNull(message="Patient is required")
    @ManyToOne(optional=false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Patient patient;

    @NotNull(message="Booking time is required")
    @FutureOrPresent(message = "Bed booking time cannot be in the past")
    private Date startTime;

    @FutureOrPresent(message = "Bed discharge time cannot be in the past")
    private Date endTime;

    @NotNull(message="Bed charge is required")
    @Min(value = 0, message="Bed charge cannot be negative")
    private Integer rate;

    public OccupiedBed() {
        super();
    }

    public OccupiedBed(@NotNull Bed bed, @NotNull Patient patient, @NotNull Date startTime, Date endTime, @NotNull @Positive Integer rate) {
        this.bed = bed;
        this.patient = patient;
        this.startTime = startTime;
        this.endTime = endTime;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "OccupiedBed [id=" + id + ", bed=" + bed + ", patient=" + patient + ", startTime=" + startTime + ", endTime=" + endTime + ", rate=" + rate + "]";
    }
}