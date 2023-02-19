package com.healthplus.dataaccess.domain;

import java.io.Serializable;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Timeslot implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public static enum DAY_OF_WEEK{
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull(message="Doctor is required")
    @ManyToOne(optional=false)
    private Doctor doctor;
    
    @NotNull(message="Day of the week is required")
    @Enumerated(EnumType.STRING)
    private DAY_OF_WEEK dayOfWeek;

    @NotNull(message="Time is required")
    private Time time;

    @NotNull(message="Number of hours of availability is required")
    @Positive(message="Number of hours of availability cannot be negative")
    private Integer hours;

    public Timeslot() {
        super();
    }

    public Timeslot(@NotNull Doctor doctor, @NotNull DAY_OF_WEEK dayOfWeek, @NotNull @FutureOrPresent Time time, @NotNull @Positive Integer hours) {
        this.doctor = doctor;
        this.dayOfWeek = dayOfWeek;
        this.time = time;
        this.hours = hours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    public DAY_OF_WEEK getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DAY_OF_WEEK dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
    
    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Timeslot [id=" + id + ", doctor=" + doctor + ", dayOfWeek=" + dayOfWeek + ", time=" + time + ", hours=" + hours + "]";
    }
}