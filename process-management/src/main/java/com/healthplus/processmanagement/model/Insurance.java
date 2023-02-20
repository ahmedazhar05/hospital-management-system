package com.healthplus.processmanagement.model;

import java.io.Serializable;

public class Insurance implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String company;
    private String description = "<em>No description available</em>";
    private Integer amountRedeemable;

    public Insurance() {
        super();
    }

    public Insurance(String company, String description, Integer amountRedeemable) {
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

    @Override
    public String toString() {
        return "Insurance [id=" + id + ", company=" + company + ", description=" + description + ", amountRedeemable=" + amountRedeemable + "]";
    }
}