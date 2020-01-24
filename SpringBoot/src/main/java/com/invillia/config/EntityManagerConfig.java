package com.invillia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
public class EntityManagerConfig {

    @Bean
    public EntityManager entityManager(){
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("account");
        return entityManagerFactory.createEntityManager();
    }
}
