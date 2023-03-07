package com.healthplus.dataaccess.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Department name is required")
    private String name;

    private String imageUrl = "https://thumbs.dreamstime.com/b/medical-staff-clinic-banner-copy-space-right-side-hospital-healthcare-background-87324362.jpg";

    public Department() {
        super();
    }

    public Department(@NotNull String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + ", imageUrl=" + imageUrl + "]";
    }
}