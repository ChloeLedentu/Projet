package com.plb.projet.service;

import static org.assertj.core.api.Assertions.assertThat;
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
	
	@Test
	public void should_find_no_members_if_repository_empty() {
		Iterable members = memberRepository.findAll();
		assertThat(members).isEmpty();
	}
	
	@Test
	public void should_find_all_members() {
		Member member1 = new Member("annie@gmail.com","Lopez","Annie","sa",0,"user", null);
		entityManager.persist(member1);
		Member member2 = new Member("Marie@gmail.com","Juno","Marie","sa",0,"user", null);
		entityManager.persist(member2);
		
		Iterable members = memberRepository.findAll();
		
		assertThat(members).hasSize(2).contains(member1, member2);
		
	}
	
	@Test
	public void should_find_member_by_email() {
	    Member member1 = new Member("annie@gmail.com","Lopez","Annie","sa",0,"user", null);
        entityManager.persist(member1);
        
        Member foundMember = memberRepository.findByEmail(member1.getEmail());
        
        assertThat(foundMember).isEqualTo(member1);
	}
	

	@Test
	public void should_update_member_by_id() {
	    Member member1 = new Member("annie@gmail.com","Lopez","Annie","sa",0,"user", null);
        entityManager.persist(member1);
        
        Member updateMember = new Member("juno@gmail.com","Juno","Marie","slo",0,"admin", null);
        
        Member memb = memberRepository.findById(member1.getId()).get();
        memb.setFirstname(updateMember.getFirstname());
        memb.setLastname(updateMember.getLastname());
        memberRepository.save(memb);
        
        Member checkMember = memberRepository.findById(member1.getId()).get();
        
        assertThat(checkMember.getId()).isEqualTo(member1.getId());
        assertThat(checkMember.getEmail()).isEqualTo(memb.getEmail());
        assertThat(checkMember.getLastname()).isEqualTo(memb.getLastname());
        assertThat(checkMember.getFirstname()).isEqualTo(memb.getFirstname());	
        
        // Probleme : memb remplace completement member1
        System.out.println(memb);
        System.out.println(member1);
        
	}
	
	@Test
	public void should_delete_member_by_id() {
	    entityManager.persist(new Member("annie@gmail.com","Lopez","Annie","sa",0,"user", null));
	    entityManager.persist(new Member("juno@gmail.com","Juno","Marie","slo",0,"admin", null));
	    
	    memberRepository.deleteAll();
	    assertThat(memberRepository.findAll()).isEmpty();
	}
	
	
}
