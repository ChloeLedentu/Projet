package com.plb.projet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plb.projet.model.Borrow;
import com.plb.projet.model.Users;
import com.plb.projet.repository.BorrowRepository;
import com.plb.projet.repository.UsersRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UserController {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    BorrowRepository borrowRepository;

    @GetMapping("/profil/{email}")
    public ResponseEntity<Users> userAccess(@PathVariable("email") String email) {

        Users usersData = usersRepository.findByEmail(email);

        if (usersData.equals(null))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(usersData, HttpStatus.OK);

    }
    @GetMapping("/user/borrow/{id}")
    public ResponseEntity<List<Borrow>> BorrowByUser(@PathVariable("id") long id) {

        List<Borrow> borrowUser = new ArrayList<Borrow>();
        borrowRepository.findByUsers(id).forEach(borrowUser::add);

        if (borrowUser.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(borrowUser, HttpStatus.OK);

    }

}
