package com.healthplus.dataaccess.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Bill implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull
    @PositiveOrZero
    private Integer total;

    @NotNull
    @FutureOrPresent
    private Date date;

    @OneToOne
    private Scheme appliedScheme;

    @OneToOne
    private Insurance appliedInsurance;

    @OneToOne
    private OccupiedBed occupiedBed;

    @NotNull
    @OneToMany(targetEntity=Prescription.class)
    private List<Prescription> prescriptions;

    @Positive
    private Integer otCharge;

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

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }
}