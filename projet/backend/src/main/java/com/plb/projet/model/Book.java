package com.plb.projet.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book extends Item {

    @Column(name = "numISBN")
    private Long numISBN;

    /* CONSTRUCTOR */

    public Book() {

    }

    public Book(String author, String title, String description, String image, LocalDate createdOn, LocalDate dateRelease, 
            int quantity, Set<Borrow> borrows, Long numISBN) {
        super(author, title, description, image, createdOn, dateRelease, quantity, borrows);

        this.numISBN = numISBN;
    }

    /* GETTERS SETTERS */

    public Long getNumISBN() {
        return numISBN;
    }

    public void setNumISBN(Long numISBN) {
        this.numISBN = numISBN;
    }

    @Override
    public String toString() {
        return " Numéro ISBN=" + numISBN + "]";
    }

}
