package com.invillia.config;

import com.invillia.service.AccountService;
import com.invillia.repository.AccountDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountApplicationConfig {

    @Bean
    public AccountService accountService(final AccountDAO accountDAO){
        return new AccountService(accountDAO);
    }
}
