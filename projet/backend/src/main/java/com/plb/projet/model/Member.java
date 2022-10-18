package com.plb.projet.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "member", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memberSequenceGenerator")
    @SequenceGenerator(name = "memberSequenceGenerator", allocationSize = 1)
    private Long id;

    @NotBlank
    @Size (max = 40)
    @Column(name = "email", nullable = false, length = 128)
    private String email;

    @Size (max = 25)
    @Column(name = "lastname", length = 128)
    private String lastname;

    @Size (max = 35)
    @Column(name = "firstname", length = 128)
    private String firstname;

    @Size (max = 120)
    @Column(name = "password", nullable = false, length = 128)
    private String password;

    @Column(name = "nbBorrow")
    private int nbBorrow;

    /* Foreign Key */

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Borrow> borrows = new HashSet<>();

    /* CONSTRUCTOR */

    public Member() {

    }

    public Member(String email, String lastname, String firstname, String password, int nbBorrow, Set<Borrow> borrows) {
        this.email = email;
        this.lastname = lastname;
        this.firstname = firstname;
        this.password = password;
        this.nbBorrow = nbBorrow;
        this.borrows = borrows;
    }

    /* GETTERS SETTERS */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNbBorrow() {
        return nbBorrow;
    }

    public void setNbBorrow(int nbBorrow) {
        this.nbBorrow = nbBorrow;
    }

    public Set<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(Set<Borrow> borrows) {
        this.borrows = borrows;
    }

    @Override
    public String toString() {
        return "Membre [id=" + id + ", prénom=" + firstname + ", nom=" + lastname + ", mot de passe="
                + password + ", email=" + email + ", nombre réservations =" + nbBorrow + "]";
    }
}
