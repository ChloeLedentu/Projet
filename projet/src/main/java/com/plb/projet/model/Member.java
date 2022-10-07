package com.plb.projet.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memberSequenceGenerator")
    @SequenceGenerator(name = "memberSequenceGenerator", allocationSize = 1)
    private Long id;

    @Column(name = "email", nullable = false, length = 128)
    private String email;

    @Column(name = "lastname", length = 128)
    private String lastname;

    @Column(name = "firstname", length = 128)
    private String firstname;

    @Column(name = "password", nullable = false, length = 128)
    private String password;

    @Column(name = "nbBorrow")
    private int nbBorrow;

    @Column(name = "role", nullable = false, length = 6)
    private String role;

    /* Foreign Key */

    @OneToMany(mappedBy = "member")
    private Set<Borrow> borrows = new HashSet<>();

    /* CONSTRUCTOR */

    public Member() {

    }

    public Member(String email, String lastname, String firstname, String password, int nbBorrow, String role,
            Set<Borrow> borrows) {
        this.email = email;
        this.lastname = lastname;
        this.firstname = firstname;
        this.password = password;
        this.nbBorrow = nbBorrow;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(Set<Borrow> borrows) {
        this.borrows = borrows;
    }

    @Override
    public String toString() {
        return "Membre [id=" + id + ", prénom=" + firstname + ", nom=" + lastname + ", role=" + role + ", mot de passe="
                + password + ", email=" + email + ", nombre réservations =" + nbBorrow + "]";
    }
}
