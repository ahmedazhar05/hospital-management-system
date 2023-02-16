package com.healthplus.dataaccess.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
class Scheme{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private int amountRedeemable;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmountRedeemable() {
		return amountRedeemable;
	}

	public void setAmountRedeemable(int amountRedeemable) {
		this.amountRedeemable = amountRedeemable;
	}
}