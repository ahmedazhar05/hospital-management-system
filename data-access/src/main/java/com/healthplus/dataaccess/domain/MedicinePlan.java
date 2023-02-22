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
public class MedicinePlan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = "Prescription is required")
	@ManyToOne(optional = false)
	private Prescription prescription;

	@NotNull(message = "Name is required")
	private String name;

	@NotNull(message = "Dosage is required")
	private String dosage;

	@Min(value = -1, message = "Duration cannot be negative")
	private Integer duration = -1;

	public MedicinePlan() {
		super();
	}

	public MedicinePlan(@NotNull Prescription prescription, @NotNull String name, @NotNull String dosage,
			@Positive Integer duration) {
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
		return "MedicinePlan [id=" + id + ", prescription=" + prescription + ", name=" + name + ", dosage=" + dosage
				+ ", duration=" + duration + "]";
	}
}