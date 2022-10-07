package com.plb.projet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "title")
public class CdTitle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "titleSequenceGenerator")
    @SequenceGenerator(name = "titleSequenceGenerator", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    // trouver le bon type float -> en minute/seconde
    @Column(name = "duration")
    private int duration;

    @ManyToOne
    private Cd cd;

    /* CONSTRUCTOR */
    public CdTitle() {

    }

    public CdTitle(String name, int duration) {
        this.name = name;
        this.duration = duration;

    }

    /* GETTERS SETTERS */
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Cd getCd() {
        return cd;
    }

    public void setCd(Cd cd) {
        this.cd = cd;
    }
    @Override
    public String toString() {
        return "Titre Cd [id=" + id + ", nom du titre=" + name + ", durée=" + duration + "]";
    }
    
}
