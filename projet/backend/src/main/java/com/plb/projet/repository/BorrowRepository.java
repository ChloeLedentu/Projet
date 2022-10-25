package com.plb.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.plb.projet.model.Borrow;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long> {

    //Integer -> can be null
    @Query(value = "SELECT SUM(b.quantity) FROM borrow b, item i, borrow_item bi WHERE bi.item_id = i.id AND b.id = bi.borrow_id AND i.id = ?1", nativeQuery = true)
    Integer sumQuantity(long id);

}
