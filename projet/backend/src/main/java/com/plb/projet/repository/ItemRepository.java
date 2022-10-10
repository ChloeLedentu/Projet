package com.plb.projet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.plb.projet.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
    
    List<Item> findAll();
    
    //Search bar
    @Query("SELECT i FROM Item i WHERE i.title LIKE %?1% or i.author LIKE %?1% ")
    List<Item> findByTitleOrAuthor(String title, String author);

    List<Item> findAllByOrderByCreatedOnAsc();
    
    @Query("SELECT d from Dvd d")
    List<Item> findAllDvd();
    
    @Query("from Cd")
    List<Item> findAllCd();
    
    @Query("from Book")
    List<Item> findAllBook();
}
