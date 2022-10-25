package com.plb.projet.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plb.projet.exception.ResourceNotFoundException;
import com.plb.projet.model.Item;
import com.plb.projet.repository.BorrowRepository;
import com.plb.projet.repository.ItemRepository;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    BorrowRepository borrowRepository;

    @GetMapping("/items{sortBy}")
    public ResponseEntity<List<Item>> getItems(@PathVariable("sortBy") String sortBy) {

        List<Item> items = new ArrayList<Item>();

        if (sortBy.isEmpty())
            itemRepository.findAllByOrderByCreatedOnAsc().forEach(items::add);
        else if (sortBy.equals("sortByTitle"))
            itemRepository.findAllByOrderByTitleAsc().forEach(items::add);
        else if (sortBy.equals("sortByAuthor"))
            itemRepository.findAllByOrderByAuthorAsc().forEach(items::add);
        else if (sortBy.equals("sortByDateRelease"))
            itemRepository.findAllByOrderByDateReleaseAsc().forEach(items::add);

        if (items.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/search={search}")
    public ResponseEntity<List<Item>> getItemBySearch(@PathVariable("search") String search) {

        List<Item> items = new ArrayList<Item>();
        itemRepository.findByTitleOrAuthor(search, search).forEach(items::add);

        if (items.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable("id") long id) {

        Optional<Item> itemData = Optional.of(itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found item with id = " + id)));

        Integer quantity = borrowRepository.sumQuantity(id);

        // calcul quantity with borrow
        if (quantity != null) {
            itemData.get().setQuantity(Math.round(itemData.get().getQuantity() - quantity));
        }

        return new ResponseEntity<>(itemData.get(), HttpStatus.OK);

    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Item>> getItemByName(@PathVariable("name") String name) {

        if (name.equals("Dvd"))
            return new ResponseEntity<>(itemRepository.findAllDvd(), HttpStatus.OK);
        else if (name.equals("Cd"))
            return new ResponseEntity<>(itemRepository.findAllCd(), HttpStatus.OK);
        else if (name.equals("Book"))
            return new ResponseEntity<>(itemRepository.findAllBook(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
