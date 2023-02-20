package com.healthplus.processmanagement.model;

import java.io.Serializable;
import java.sql.Time;

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

    private Long id;
    private Doctor doctor;
    private DAY_OF_WEEK dayOfWeek;
    private Time time;
    private Integer hours;

    public Timeslot() {
        super();
    }

    public Timeslot(Doctor doctor, DAY_OF_WEEK dayOfWeek, Time time, Integer hours) {
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