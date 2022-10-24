package com.plb.projet.service;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.plb.projet.repository.BorrowRepository;

@DataJpaTest
public class BorrowRepositoryTest {


    @Autowired
    private BorrowRepository borrowRepository;

    
    @BeforeEach
    public void assertEach() {

        System.out.println("***********************************************************");
    }
  
    
    
}
