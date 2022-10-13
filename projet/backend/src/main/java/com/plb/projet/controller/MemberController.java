package com.plb.projet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plb.projet.model.Member;
import com.plb.projet.repository.MemberRepository;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api")
public class MemberController {

    @Autowired
    MemberRepository memberRepository;
  

    @GetMapping("/login")
    public ResponseEntity<Member> getUserConnexion(@PathVariable("email") String email,
            @PathVariable("password") String password) {
        
        // check variables not null
        if (email == null || password == null)
            return ResponseEntity.notFound().build();
        
        Member member = memberRepository.findByEmail(email);
        
        // check user exist
        if (member == null)
            return ResponseEntity.notFound().build();
        
        else {
            
            //check password
            if (member.getPassword() != password)
                return ResponseEntity.notFound().build();
            
            else
                // ! creation du token 
                return ResponseEntity.ok(member);
        }
    }
    @GetMapping("/members")
    public ResponseEntity<List<Member>> getAll(){
        List<Member> allmember = memberRepository.findAll();
        return ResponseEntity.ok(allmember);
    }
}
