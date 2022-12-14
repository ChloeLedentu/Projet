package com.plb.projet.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.plb.projet.model.Item;
import com.plb.projet.repository.ItemRepository;

@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @BeforeEach
    public void assertEach() {

        System.out.println("***********************************************************");
    }

    @Test
    @Order(1)
    public void should_find_dvd() {

        List<Item> items = itemRepository.findAllDvd();
        assertEquals("avengers: endgame", items.get(0).getTitle());
    }

    @Test
    @Order(2)
    public void should_find_by_title() {

        List<Item> items = itemRepository.findByTitleOrAuthor("dents", "");
        assertEquals("les dents de la mer", items.get(0).getTitle());
    }

}
