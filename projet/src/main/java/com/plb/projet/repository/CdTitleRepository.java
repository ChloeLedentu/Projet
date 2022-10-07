package com.plb.projet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plb.projet.model.CdTitle;

public interface CdTitleRepository extends JpaRepository<CdTitle, Long> {

    CdTitle findByName(String name);
    CdTitle findById(long id);
    
    List<CdTitle> findAll();
}
