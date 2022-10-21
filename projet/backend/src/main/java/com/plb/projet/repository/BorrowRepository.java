package com.plb.projet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.plb.projet.model.Borrow;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long> {

    Optional<Borrow> findById(long id);
    
    List<Borrow> findByUsers(long id);
    
    List<Borrow> findByItems(long id);
    
    List<Borrow> findAll();
}
