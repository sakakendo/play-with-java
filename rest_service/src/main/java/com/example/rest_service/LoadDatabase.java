package com.example.rest_service;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository, OrderRepository orderRepository){
        return args -> {
            log.info("Preloading " + repository.save(new Employee("Blido Baggins", "burglar")));
            log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));
            log.info("Preloading " + orderRepository.save(new Order("MacBook Pro", Status.COMPLETED)));
            log.info("Preloading " + orderRepository.save(new Order("iPhone", Status.IN_PROGRESS)));
        };
    }
}