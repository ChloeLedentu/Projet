package com.plb.projet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plb.projet.model.Borrow;
import com.plb.projet.model.Item;
import com.plb.projet.repository.BorrowRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class BorrowConstroller {

    @Autowired
    BorrowRepository borrowRepository;
    
    @GetMapping("/borrow/user/{id}")
    public ResponseEntity<List<Borrow>> BorrowByUser(@PathVariable("id") long id){
        try {
            List<Borrow> borrowUser = new ArrayList<Borrow>();
            borrowRepository.findByUsersId(id).forEach(borrowUser::add);
            
            if (borrowUser.isEmpty())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(borrowUser, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/borrow/item/{id}")
    public ResponseEntity<List<Borrow>> BorrowByItemr(@PathVariable("id") long id){
        try {
            
            List<Borrow> borrowItems = borrowRepository.findByItems(id);
            
            if (borrowItems.isEmpty())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(borrowItems, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
}
