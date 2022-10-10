package com.plb.projet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plb.projet.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	
    Member findById(long id);
    Member findByEmail(String email);
    
    List<Member> findAll();
	
	
}
