package com.healthplus.processmanagement.model;

import java.io.Serializable;

public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String name;
    private String imageUrl; // TODO: assign a default image URL to this

    public Department() {
        super();
    }

    public Department(String name, String imageUrl) {
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