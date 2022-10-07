package com.plb.projet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plb.projet.model.Cd;

public interface CdRepository extends JpaRepository<Cd, Long>{

    List<Cd> findAll();
}
