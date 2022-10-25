package com.plb.projet.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.plb.projet.model.Item;
import com.plb.projet.repository.BorrowRepository;
import com.plb.projet.repository.ItemRepository;

@DataJpaTest
public class BorrowRepositoryTest {


    @Autowired
    private BorrowRepository borrowRepository;
    
    @Autowired
    private ItemRepository itemRepository;

    
    @BeforeEach
    public void assertEach() {

        System.out.println("***********************************************************");
    }
    
    @Test
    public void sum_quantity_by_items() {
       
       int qtt = borrowRepository.sumQuantity(2);
       Optional<Item> dataItem = itemRepository.findById(2l);
       
       //quantity (in item) - sum borrow
       Integer Total = Math.round(dataItem.get().getQuantity() - qtt);
       
       assertEquals(Total, 0);
        
    }
  
    
    
}
