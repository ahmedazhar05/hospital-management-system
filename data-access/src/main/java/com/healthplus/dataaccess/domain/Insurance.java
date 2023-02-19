package com.healthplus.dataaccess.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Insurance implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull
    private String company;

    private String description;

    @NotNull
    @Positive
    private Integer amountRedeemable;

    public Insurance() {
		super();
	}

    public Insurance(@NotNull String company, String description, @NotNull @Positive Integer amountRedeemable) {
		this.company = company;
		this.description = description;
		this.amountRedeemable = amountRedeemable;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmountRedeemable() {
        return amountRedeemable;
    }

    public void setAmountRedeemable(Integer amountRedeemable) {
        this.amountRedeemable = amountRedeemable;
    }
}