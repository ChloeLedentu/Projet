package com.plb.projet.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "borrow")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "borrowSequenceGenerator")
    @SequenceGenerator(name = "borrowSequenceGenerator", allocationSize = 1)
    private Long id;

    @Column(name = "dateTake", nullable = false)
    private LocalDate dateTake;

    @Column(name = "dateReturn")
    private LocalDate dateReturn;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    /* Foreign Key */

    @ManyToOne
    private Member member;

    @ManyToMany(mappedBy = "borrows", cascade = CascadeType.REMOVE)
    private Set<Item> items = new HashSet<>();

    /* CONSTRUCTOR */

    public Borrow(LocalDate dateTake, LocalDate dateReturn, int quantity, Member member, Set<Item> items) {
        this.dateTake = dateTake;
        this.dateReturn = dateReturn;
        this.quantity = quantity;
        this.member = member;
        this.items = items;
    }

    public Borrow() {

    }

    /* GETTERS SETTERS */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateTake() {
        return dateTake;
    }

    public void setDateTake(LocalDate dateTake) {
        this.dateTake = dateTake;
    }

    public LocalDate getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(LocalDate dateReturn) {
        this.dateReturn = dateReturn;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Réservation [id=" + id +
                ", membre=" + member + 
                ", pris le=" + dateTake + 
                ", Date rendu=" + dateReturn + 
                ", quantité=" + quantity + 
                ", objet=" + items + "]";
    }

}
