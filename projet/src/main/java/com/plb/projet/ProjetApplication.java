package com.plb.projet;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

import com.plb.projet.model.Book;
import com.plb.projet.model.Borrow;
import com.plb.projet.model.Cd;
import com.plb.projet.model.Dvd;
import com.plb.projet.model.Item;
import com.plb.projet.model.Member;
import com.plb.projet.repository.BookRepository;
import com.plb.projet.repository.BorrowRepository;
import com.plb.projet.repository.CdRepository;
import com.plb.projet.repository.DvdRepository;
import com.plb.projet.repository.ItemRepository;
import com.plb.projet.repository.MemberRepository;

@SpringBootApplication
public class ProjetApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ProjetApplication.class);
        ConfigurableEnvironment environment = new StandardEnvironment();
        environment.setDefaultProfiles("dev");
        application.setEnvironment(environment);
        application.run(args);
    }

 
}
