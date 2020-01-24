package com.invillia.config;

import com.invillia.repository.AccountDAO;
import com.invillia.repository.AccountDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class AccountDAOConfig {

    @Bean
    public AccountDAO accountDAO(final EntityManager entityManager){
        return new AccountDAOImpl(entityManager);
    }
}
