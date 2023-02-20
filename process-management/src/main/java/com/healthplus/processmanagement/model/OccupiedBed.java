package com.healthplus.processmanagement.model;

import java.io.Serializable;
import java.util.Date;

public class OccupiedBed implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Bed bed;
    private Patient patient;
    private Date startTime;
    private Date endTime;
    private Integer rate;

    public OccupiedBed() {
        super();
    }

    public OccupiedBed(Bed bed, Patient patient, Date startTime, Date endTime, Integer rate) {
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