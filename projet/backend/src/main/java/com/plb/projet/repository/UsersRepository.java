package com.plb.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plb.projet.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
	
    Users findByEmail(String email);
    Boolean existsByEmail(String email);
	
}
