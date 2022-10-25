package com.plb.projet.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.plb.projet.model.Users;
import com.plb.projet.repository.UsersRepository;

@DataJpaTest
public class UserRepositoryTest {
    
    @Autowired
    private UsersRepository usersRepository;
    
    
    @BeforeEach
    public void assertEach() {
        System.out.println("***********************************************************");
    }

    @Test
    @Order(1)
    public void should_find_users_if_repository_isnot_empty() {
        
        Iterable users = usersRepository.findAll();
        assertThat(users).isNotEmpty();
    }

    @Test
    @Order(2)
    public void should_find_user_by_email() {
       Optional<Users> findUser = usersRepository.findByEmail("toto@f.c");
       assertEquals("toto", findUser.get().getLastname());
    }

}
