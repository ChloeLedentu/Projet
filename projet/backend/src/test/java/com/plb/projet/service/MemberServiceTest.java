package com.plb.projet.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.plb.projet.model.Member;
import com.plb.projet.repository.MemberRepository;

@DataJpaTest
public class MemberServiceTest {
    
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MemberRepository memberRepository;
    
    
    @BeforeEach
    public void assertEach() {
        System.out.println("***********************************************************");
    }

    @Test
    @Order(1)
    public void should_find_members_if_repository_isnot_empty() {
        
        Iterable members = memberRepository.findAll();
        assertThat(members).isNotEmpty();
    }

    @Test
    @Order(2)
    public void should_find_all_members() {
        
        Member member1 = new Member("annie@gmail.com", "Lopez", "Annie", "sa", 0, null);
        entityManager.persist(member1);
        Member member2 = new Member("Marie@gmail.com", "Juno", "Marie", "sa", 0, null);
        entityManager.persist(member2);

        Iterable members = memberRepository.findAll();

        assertThat(members).hasSize(2).contains(member1, member2);
    }

    @Test
    @Order(3)
    public void should_find_member_by_email() {
        Member member1 = new Member("annie@gmail.com", "Lopez", "Annie", "sa", 0, null);
        entityManager.persist(member1);

        Member foundMember = memberRepository.findByEmail(member1.getEmail());
        
        assertThat(foundMember).isEqualTo(member1);
    }

    @Test
    @Order(4)
    public void should_find_by_id() {
        Member member1 = new Member("annie@gmail.com", "Lopez", "Annie", "sa", 0, null);
        entityManager.persist(member1);

        Member foundMember = memberRepository.findById(member1.getId()).get();
        
        assertThat(foundMember).isEqualTo(member1);
    }

    @Test
    @Order(5)
    public void should_update_member_by_id() {
        Member member1 = new Member("phanie@gmail.com", "Pnod", "Phanie", "bla", 0, null);
        entityManager.persist(member1);

        //many differents informations 
        Member updateMember = new Member("juno@gmail.com", "Juno", "Marie", "slo", 0, null);

        //only firstname and lastname change
        Member memb = memberRepository.findById(member1.getId()).get();
        memb.setFirstname(updateMember.getFirstname());
        memb.setLastname(updateMember.getLastname());
        memberRepository.save(memb);

        assertThat(memb.getId()).isEqualTo(member1.getId());
        assertThat(updateMember.getEmail()).isEqualTo(member1.getEmail());
        assertThat(updateMember.getLastname()).isEqualTo(member1.getLastname());
    }

    @Test
    @Order(6)
    public void should_delete_member_by_id() {
        entityManager.persist(new Member("annie@gmail.com", "Lopez", "Annie", "sa", 0, null));
        entityManager.persist(new Member("juno@gmail.com", "Juno", "Marie", "slo", 0, null));

        memberRepository.deleteAll();
        assertThat(memberRepository.findAll()).isEmpty();
    }

    @AfterAll
    public static void cleanUp() {
        System.out.println("After All cleanUp() method called");
    }

}
