package com.esprit.microservices.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class CandidateApplication {

    public static void main(String[] args) {
        SpringApplication.run(CandidateApplication.class, args);
    }

    @Autowired
    private CandidatRepository repository;

    @Bean
    ApplicationRunner init (){
        return (args) -> {
            repository.save(new Candidat(1,"meriem","ch","ahlem.said@esprit.tn"));
            repository.save(new Candidat(5,"ahlem","said","ahlem.said@esprit.tn"));
            repository.save(new Candidat(6,"nacer","ismail","ahlem.said@esprit.tn"));
            repository.findAll().forEach(System.out::println);
        };
    }

}
