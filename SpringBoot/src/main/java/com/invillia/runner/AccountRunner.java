package com.invillia.runner;

import com.invillia.repository.AccountDAO;
import com.invillia.account.Account;
import com.invillia.service.AccountService;
import org.springframework.stereotype.Component;

@Component
public class AccountRunner implements ApplicationRunner {

    private final AccountService accountService;
    private final AccountDAO accountDAO;

    public AccountRunner(AccountService accountService, AccountDAO accountDAO) {
        this.accountService = accountService;
        this.accountDAO = accountDAO;
    }

    @Override
    public void run() {
       // final Account account = new Account("Rafael", 1000.0, TypeAccount.CHECKINGACCOUNT);
        final Account account = accountDAO.findById(1L);
        accountService.deposit(account, 4000.0);


    }
}
