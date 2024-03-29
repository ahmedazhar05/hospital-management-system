package com.healthplus.dataaccess.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Bill implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Total should be calculated for a bill")
    @Min(value = 0, message="Total cannot be negative")
    private Integer total;

    @NotNull(message = "Date is required")
    @FutureOrPresent(message = "Bill cannot be created in advance")
    private Date date;

    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Scheme appliedScheme;

    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Insurance appliedInsurance;

    @OneToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private OccupiedBed occupiedBed;

    @NotNull(message = "There should be atleast one prescription for billing")
    @OneToMany
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<Prescription> prescriptions;

    @Min(value = 0, message="OT charge cannot be negative")
    private Integer otCharge;

    public Bill() {
        super();
    }

    public Bill(@NotNull @PositiveOrZero Integer total, @NotNull @FutureOrPresent Date date, Scheme appliedScheme, Insurance appliedInsurance, OccupiedBed occupiedBed, @NotNull Set<Prescription> prescriptions, @Positive Integer otCharge) {
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