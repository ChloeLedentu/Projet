package com.plb.projet.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plb.projet.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

    List<Item> findByAuthor (String author);
    List<Item> findByCreatedOn(Instant createdOn);
    Item findById(long id);
    List<Item> findByDateRelease(Instant dateRelease);
    
    List<Item> findAll();
}
