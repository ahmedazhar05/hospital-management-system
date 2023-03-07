package com.healthplus.dataaccess.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Scheme implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull(message="Scheme name is required")
    private String name;

    private String description = "<em>No description available</em>";

    @NotNull(message="Deductable amount is required")
    @Min(value=0, message="Amount cannot be negative")
    private Integer amountRedeemable;

    public Scheme() {
        super();
    }

    public Scheme(@NotNull String name, String description, @NotNull Integer amountRedeemable) {
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