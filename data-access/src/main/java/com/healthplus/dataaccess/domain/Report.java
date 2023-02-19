package com.healthplus.dataaccess.domain;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
public class Report implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull(message="Patient is required")
    @ManyToOne(optional=false)
    private Patient patient;

    @NotNull(message="Name is required")
    private String name;
    
    @PastOrPresent(message="Date cannot be in the future")
    private Date date = new Date();

    @NotNull(message="File path is required")
    private String fileUrl;

    public Report() {
        super();
    }

    public Report(@NotNull Patient patient, @NotNull String name, @PastOrPresent Date date, @NotNull String fileUrl) {
        this.patient = patient;
        this.name = name;
        this.date = date;
        this.fileUrl = fileUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public String toString() {
        return "Report [id=" + id + ", patient=" + patient + ", name=" + name + ", date=" + date + ", fileUrl=" + fileUrl + "]";
    }
}