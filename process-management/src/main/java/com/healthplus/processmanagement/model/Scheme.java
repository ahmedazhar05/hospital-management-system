package com.healthplus.processmanagement.model;

import java.io.Serializable;

public class Scheme implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description = "<em>No description available</em>";
    private Integer amountRedeemable;

    public Scheme() {
        super();
    }

    public Scheme(String name, String description, Integer amountRedeemable) {
        this.name = name;
        this.description = description;
        this.amountRedeemable = amountRedeemable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getAmountRedeemable() {
        return amountRedeemable;
    }

    public void setAmountRedeemable(Integer amountRedeemable) {
        this.amountRedeemable = amountRedeemable;
    }

    @Override
    public String toString() {
        return "Scheme [id=" + id + ", name=" + name + ", description=" + description + ", amountRedeemable=" + amountRedeemable + "]";
    }
}