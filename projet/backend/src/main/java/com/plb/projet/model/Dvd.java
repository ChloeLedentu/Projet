package com.plb.projet.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "dvd")
public class Dvd extends Item {

    @Column(name = "duration")
    private int duration;

    @Size (max = 35)
    @Column(name = "type", nullable = false)
    private String type;

    /* CONSTRUCTOR */

    public Dvd() {

    }

    public Dvd(String author, String title, String description, String image, LocalDate createdOn, LocalDate dateRelease, 
            int quantity, Set<Borrow> borrows, int duration, String type) {
        super(author, title, description, image, createdOn, dateRelease, quantity, borrows);
        this.duration = duration;
        this.type = type;
    }

    /* GETTERS SETTERS */

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "type=" + type + ", durée=" + duration + "minutes ]";
    }

}
