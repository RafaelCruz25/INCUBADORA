package com.invillia.service;

import com.invillia.account.Account;
import com.invillia.repository.AccountDAO;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountDAO accountDAO;

    public AccountService(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    public void withdraw(Account account, Double amount){

        if(account.getTypeAccount().type.equals("CHECKINGACCOUNT")) {
            if (account.getBalance() > 0 && account.getBalance() <= amount) {
                account.setBalance(account.getBalance() - amount);
                accountDAO.update(account);

            } else if (account.getBalance() + account.getLoanLimit() >= amount) {
                account.setBalance(account.getBalance() - amount);
                accountDAO.update(account);
            } else {
                System.out.println("VALOR INVALIDO!");
            }
        }
        else{
            if(account.getBalance() > 0 && amount <= account.getBalance()){
                account.setBalance(account.getBalance() - amount);
                accountDAO.update(account);
            }
            else{
                System.out.println("VALOR INVALIDO!");
                System.out.println("CONTA NÃO POSSUI LIMITE DISPONIVEL!");
            }

        }

    }

    public void deposit(Account account, Double amount){
        if(amount > 0) {
            account.setBalance(account.getBalance() + amount);
            accountDAO.update(account);
        }
        else
            System.out.println("VALOR INVALIDO!!");
    }

    public void insert(Account account){
        accountDAO.insert(account);
    }

    public void update(Account account){
        accountDAO.update(account);
    }

    public void removeById(final Long id){
        accountDAO.removeById(id);
    }


}
