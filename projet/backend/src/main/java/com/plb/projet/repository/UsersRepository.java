package com.plb.projet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plb.projet.model.Borrow;
import com.plb.projet.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
	
    Optional<Users> findByEmail(String email);
    Boolean existsByEmail(String email);
    
	
}
