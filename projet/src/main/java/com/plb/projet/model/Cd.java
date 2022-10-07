package com.plb.projet.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cd")
public class Cd extends Item {

    @Column(name = "nbTitle", nullable = false)
    private int nbTitle;

    /* Foreign Key */

    @OneToMany(mappedBy = "cd")
    private Set<CdTitle> titles = new HashSet<>();

    /* CONSTRUCTOR */

    public Cd() {

    }

    public Cd(String author, String title, String description, String image, LocalDate createdOn, LocalDate dateRelease, 
            int quantity, Set<Borrow> borrows, int nbTitle, Set<CdTitle> titles) {
        super(author, title, description, image, createdOn, dateRelease, quantity, borrows);
        this.nbTitle = nbTitle;
    }

    /* GETTERS SETTERS */

    public int getNbTitle() {
        return nbTitle;
    }

    public void setNbTitle(int nbTitle) {
        this.nbTitle = nbTitle;
    }

    public Set<CdTitle> getTitles() {
        return titles;
    }

    public void setTitles(Set<CdTitle> titles) {
        this.titles = titles;
    }

    @Override
    public String toString() {
        return " Nombre de titres=" + nbTitle + "]";
    }

}
