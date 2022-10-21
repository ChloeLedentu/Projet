package com.plb.projet.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.micrometer.core.lang.Nullable;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usersSequenceGenerator")
    @SequenceGenerator(name = "usersSequenceGenerator", allocationSize = 1)
    private Long id;

    @NotBlank
    @Size(max = 40)
    @Column(name = "email", nullable = false, length = 128)
    private String email;

    @Size(max = 35)
    @NotBlank
    @Column(name = "firstname", length = 128)
    private String firstname;

    @Size(max = 25)
    @NotBlank
    @Column(name = "lastname", length = 128)
    private String lastname;

    @Size(max = 120)
    @NotBlank
    @Column(name = "password", nullable = false, length = 128)
    private String password;
    
    @Column(name = "nbBorrow")
    @Nullable
    private int nbBorrow;


    /* Foreign Key */

    @OneToMany(mappedBy = "users", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Borrow> borrows = new HashSet<>();

    /* CONSTRUCTOR */

    public Users() {
    }

    public Users(String firstname, String lastname, String email, String password) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
    }

    /* GETTERS SETTERS */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "User [id=" + id + ", prénom=" + firstname + ", nom=" + lastname + ", mot de passe="
                + password + ", email=" + email + ", nombre réservations =" + nbBorrow + "]";
    }
}
