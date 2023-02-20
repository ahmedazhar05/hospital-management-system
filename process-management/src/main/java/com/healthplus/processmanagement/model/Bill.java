package com.healthplus.processmanagement.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Bill implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Integer total;
    private Date date;
    private Scheme appliedScheme;
    private Insurance appliedInsurance;
    private OccupiedBed occupiedBed;
    private Set<Prescription> prescriptions;
    private Integer otCharge;

    public Bill() {
        super();
    }

    public Bill(Integer total, Date date, Scheme appliedScheme, Insurance appliedInsurance, OccupiedBed occupiedBed, Set<Prescription> prescriptions, Integer otCharge) {
        this.total = total;
        this.date = date;
        this.appliedScheme = appliedScheme;
        this.appliedInsurance = appliedInsurance;
        this.occupiedBed = occupiedBed;
        this.prescriptions = prescriptions;
        this.otCharge = otCharge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Scheme getAppliedScheme() {
        return appliedScheme;
    }

    public void setAppliedScheme(Scheme appliedScheme) {
        this.appliedScheme = appliedScheme;
    }

    public Insurance getAppliedInsurance() {
        return appliedInsurance;
    }

    public void setAppliedInsurance(Insurance appliedInsurance) {
        this.appliedInsurance = appliedInsurance;
    }

    public OccupiedBed getOccupiedBed() {
        return occupiedBed;
    }

    public void setOccupiedBed(OccupiedBed occupiedBed) {
        this.occupiedBed = occupiedBed;
    }

    public Integer getOtCharge() {
        return otCharge;
    }

    public void setOtCharge(Integer otCharge) {
        this.otCharge = otCharge;
    }

    public Set<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(Set<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    @Override
    public String toString() {
        return "Bill [id=" + id + ", total=" + total + ", date=" + date + ", appliedScheme=" + appliedScheme + ", appliedInsurance=" + appliedInsurance + ", occupiedBed=" + occupiedBed + ", prescriptions=" + prescriptions + ", otCharge=" + otCharge + "]";
    }
}