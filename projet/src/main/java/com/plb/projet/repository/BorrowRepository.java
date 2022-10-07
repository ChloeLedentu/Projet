package com.plb.projet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plb.projet.model.Borrow;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {

    Borrow findById(long id);
    
    List<Borrow> findAll();
}
