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
    private long numISBN;

    /* CONSTRUCTOR */

    public Book() {

    }

    public Book(String author, String title, String description, String image, LocalDate createdOn, LocalDate dateRelease, 
            int quantity, Set<Borrow> borrows, long numISBN) {
        super(author, title, description, image, createdOn, dateRelease, quantity, borrows);

        this.numISBN = numISBN;
    }

    /* GETTERS SETTERS */

    public long getNumISBN() {
        return numISBN;
    }

    public void setNumISBN(long numISBN) {
        this.numISBN = numISBN;
    }

    @Override
    public String toString() {
        return " Numéro ISBN=" + numISBN + "]";
    }

}
