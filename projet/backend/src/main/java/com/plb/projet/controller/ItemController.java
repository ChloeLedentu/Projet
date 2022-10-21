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

import com.plb.projet.model.Item;
import com.plb.projet.repository.ItemRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/items{sortBy}")
    public ResponseEntity<List<Item>> getItems(@PathVariable("sortBy") String sortBy) {
        try {
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

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search={search}")
    public ResponseEntity<List<Item>> getItemBySearch(@PathVariable("search") String search) {
        try {
            List<Item> items = new ArrayList<Item>();
            itemRepository.findByTitleOrAuthor(search, search).forEach(items::add);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable("id") long id) {
        try {
            Optional<Item> itemData = itemRepository.findById(id);

            if (itemData.isPresent())
                return new ResponseEntity<>(itemData.get(), HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/item-{name}")
    public ResponseEntity<List<Item>> getItemByName(@PathVariable("name") String name) {
        try {
            if (name.isEmpty())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else if (name.equals("Dvd"))
                return new ResponseEntity<>(itemRepository.findAllDvd(), HttpStatus.OK);
            else if (name.equals("Cd"))
                return new ResponseEntity<>(itemRepository.findAllCd(), HttpStatus.OK);
            else if (name.equals("Book"))
                return new ResponseEntity<>(itemRepository.findAllBook(), HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
