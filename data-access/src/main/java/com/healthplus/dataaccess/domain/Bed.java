package com.healthplus.dataaccess.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
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

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ROOM room;

    @NotNull
    @Enumerated(EnumType.STRING)
    private BED type;

    @NotNull
    @Enumerated(EnumType.STRING)
    private FACILITY facility;

    @NotNull
    @Positive
    private Integer availability;

    public Bed() {
        super();
    }

    public Bed(@NotNull ROOM room, @NotNull BED type, @NotNull FACILITY facility, @NotNull @Positive Integer availability) {
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