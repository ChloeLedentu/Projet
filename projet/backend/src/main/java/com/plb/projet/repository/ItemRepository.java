package com.plb.projet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.plb.projet.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
    
   //************** ITEM ******************
    
    @Query("FROM Item i ORDER BY i.createdOn ASC")
    List<Item> findAllByOrderByCreatedOnAsc();
    
     //Search bar
    @Query("FROM Item i WHERE ( i.title LIKE %?1% OR i.author LIKE %?1% ) AND i.quantity > 0 ")
    List<Item> findByTitleOrAuthor(String title, String author);
    
    //SORT BY
    @Query("FROM Item i ORDER BY i.dateRelease ASC")
    List<Item> findAllByOrderByDateReleaseAsc();
    @Query("FROM Item i ORDER BY i.title ASC")
    List<Item> findAllByOrderByTitleAsc();
    @Query("FROM Item i ORDER BY i.author ASC ")
    List<Item> findAllByOrderByAuthorAsc();
    
    
    @Query("FROM Dvd d")
    List<Item> findAllDvd();
    @Query("FROM Cd c")
    List<Item> findAllCd();
    @Query("FROM Book b")
    List<Item> findAllBook();
    
}
