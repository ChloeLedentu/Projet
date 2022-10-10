package com.plb.projet.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.plb.projet.model.Book;
import com.plb.projet.model.Borrow;
import com.plb.projet.model.Item;
import com.plb.projet.repository.ItemRepository;

@DataJpaTest
public class ItemServiceTest {

    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private ItemRepository itemRepository;
    
    @BeforeEach
    public void assertEach() {
        
        System.out.println("***********************************************************");
    }
    
    @Test
    @Order(1)
    public void should_find_items_if_repository_isnot_empty(){
        
         Iterable items = itemRepository.findAll();
         assertThat(items).isNotEmpty();
    }
    
    @Test
    @Order(2)
    public void should_find_all_items() {
        
        //Item item1 = new Item("")
    }
    
    @Test
    @Order(3)
    public void should_find_all_books() {
        Book book1 = new Book("Sandra Thomann", "Je batch cook toute l'année", "Vous avez toujours rêvé..", null, LocalDate.now(), LocalDate.of(2019,9,18), 
            2, null, 2035995574l);
        entityManager.persist(book1);
        
        Item book = itemRepository.findById(book1.getId()).get();
        
        Iterable items = itemRepository.findAll();
        assertThat(items).contains(book1);
        assertThat(book.getAuthor()).isEqualTo("Sandra Thomann");
    }
    
}
