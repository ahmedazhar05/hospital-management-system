package com.healthplus.dataaccess.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Bill implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @NotNull
    @Min(0)
    private int total;

    @NotNull
    @FutureOrPresent
    private Date date;

    private Scheme appliedScheme;

    private Insurance appliedInsurance;

    private OccupiedBed occupiedBed;
    
    @OneToMany(targetEntity=Prescription.class)
    private List<Prescription> prescriptions;

    @Positive
	private int otCharge;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
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

	public int getOtCharge() {
		return otCharge;
	}

	public void setOtCharge(int otCharge) {
		this.otCharge = otCharge;
	}

    public List<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}
}