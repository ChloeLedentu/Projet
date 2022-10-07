package com.plb.projet.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.plb.projet.model.Dvd;

public interface DvdRepository extends JpaRepository<Dvd, Long> {

    List<Dvd> findByType(String type);
    
    List<Dvd> findAll();
}
