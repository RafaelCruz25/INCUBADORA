package com.invillia.repository;

import com.invillia.account.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDAO {

    Account findById(final Long id);

    List<Account> findAll();

    void insert(Account account);

    void update(Account account);

    void removeById(final Long id);
}