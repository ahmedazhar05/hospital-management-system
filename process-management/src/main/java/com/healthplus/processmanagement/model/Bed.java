package com.healthplus.processmanagement.model;

import java.io.Serializable;

public class Bed implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public static enum ROOM{
        PRIVATE,
        SEMI_PRIVATE,
        MALE_GENERAL,
        FEMALE_GENERAL
    }
    
    public static enum BED{
        ICU,
        NORMAL
    }
    
    public static enum FACILITY{
        AC,
        NON_AC
    }

    private Long id;
    private ROOM room;
    private BED type;
    private FACILITY facility;
    private Integer availability;

    public Bed() {
        super();
    }

    public Bed(ROOM room, BED type, FACILITY facility, Integer availability) {
        this.room = room;
        this.type = type;
        this.facility = facility;
        this.availability = availability;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ROOM getRoom() {
        return room;
    }

    public void setRoom(ROOM room) {
        this.room = room;
    }

    public BED getType() {
        return type;
    }

    public void setType(BED type) {
        this.type = type;
    }

    public FACILITY getFacility() {
        return facility;
    }

    public void setFacility(FACILITY facility) {
        this.facility = facility;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Bed [id=" + id + ", room=" + room + ", type=" + type + ", facility=" + facility + ", availability=" + availability + "]";
    }
}