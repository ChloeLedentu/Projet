package com.plb.projet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plb.projet.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

    List<Book> findAll();
}
