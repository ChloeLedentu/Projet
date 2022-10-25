package com.plb.projet.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plb.projet.exception.ResourceNotFoundException;
import com.plb.projet.model.Borrow;
import com.plb.projet.model.Item;
import com.plb.projet.model.Users;
import com.plb.projet.repository.BorrowRepository;
import com.plb.projet.repository.ItemRepository;
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

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/profil/{email}")
    public ResponseEntity<Users> userAccess(@PathVariable("email") String email) {

        Optional<Users> usersData = Optional.of(usersRepository.findByEmail(email))
                .orElseThrow(() -> new ResourceNotFoundException("Not found user with email = " + email));

        return new ResponseEntity<>(usersData.get(), HttpStatus.OK);

    }

    @GetMapping("/user/borrow/{id}")
    public ResponseEntity<List<Borrow>> BorrowsByUser(@PathVariable("id") long id) {

        Optional<Users> usersData = usersRepository.findById(id);

        List<Borrow> borrowsUser = new ArrayList<Borrow>();
        usersData.get().getBorrows().forEach(borrowsUser::add);

        if (borrowsUser.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(borrowsUser, HttpStatus.OK);
    }

    @PutMapping("/borrow/update/{id}/{quantity}")
    public ResponseEntity<?> borrowUpdateDateReturn(@PathVariable(value = "id") long id,
            @PathVariable(value = "quantity") int quantity) {

        Optional<Borrow> _borrow = Optional.of(borrowRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found borrow with id = " + id)));

        // recup user
        Optional<Users> _user = usersRepository.findById(_borrow.get().getUsers().getId());

        // Calcul : quantite return + number of borrow of the user
        _user.get().setNbBorrow(Math.round(_user.get().getNbBorrow() - quantity));

        if (_user.get().getNbBorrow() <= 3) {
            // remove the quantity of borrowing chosen
            _borrow.get().setQuantity(Math.round(_borrow.get().getQuantity() - quantity));
            // if borrow quantity = 0
            if (_borrow.get().getQuantity() == 0) {
                // add DateReturn
                _borrow.get().setDateReturn(LocalDate.now());
            }
        } else {
            // no borrow found
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Erreur de quantité");
        }

        // save
        usersRepository.save(_user.get());
        borrowRepository.save(_borrow.get());
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PostMapping("/borrow/new/{userId}/{itemId}")
    public ResponseEntity<?> NewBorrows(@PathVariable("userId") long userId, @PathVariable("itemId") long itemId) {

        Item _item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found item with id = " + itemId));

        Users _user = usersRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found user with id = " + userId));

        if (Math.round(_user.getNbBorrow() + 1) <= 3) {

            Borrow _borrow = new Borrow();
            _borrow.setDateReturn(null);
            _borrow.setDateTake(LocalDate.now());
            _borrow.setQuantity(1);
            _borrow.setUsers(_user);
            _item.getBorrows().add(_borrow);
            borrowRepository.save(_borrow);

            _user.setNbBorrow(Math.round(_user.getNbBorrow() + 1));
            usersRepository.save(_user);
            return new ResponseEntity<>(HttpStatus.CREATED);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Maximum de réservations atteint");
        }

    }

}
