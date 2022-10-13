package com.plb.projet.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "item")
@Inheritance(strategy = InheritanceType.JOINED)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "titleSequenceGenerator")
    @SequenceGenerator(name = "titleSequenceGenerator", allocationSize = 1)
    private Long id;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "dateRelease")
    private LocalDate dateRelease;

    @Column(name = "description", nullable = false)
    @Type(type = "text")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "createdOn", nullable = false)
    private LocalDate createdOn;
    /* Foreign Key */

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "borrow_item", joinColumns = @JoinColumn(name = "borrow_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Set<Borrow> borrows = new HashSet<>();

    /* CONTRUCTOR */

    public Item() {

    }

    public Item(String author, String title, String description, String image, LocalDate createdOn,
            LocalDate dateRelease, int quantity, Set<Borrow> borrows) {
        this.author = author;
        this.title = title;
        this.dateRelease = dateRelease;
        this.description = description;
        this.image = image;
        this.quantity = quantity;
        this.createdOn = createdOn; 
        this.borrows = borrows;
    }
       

    /* GETTERS SETTERS */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(LocalDate dateRelease) {
        this.dateRelease = dateRelease;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public Set<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(Set<Borrow> borrows) {
        this.borrows = borrows;
    }

    @Override
    public String toString() {
        return "Objet [id=" + id + ", auteur=" + author + ", crée le=" + createdOn + ", Date publication=" + dateRelease
                + ", image=" + image + ", quantité=" + quantity + ", description=" + description;
    }

}
