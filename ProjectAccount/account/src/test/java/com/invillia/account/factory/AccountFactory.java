package com.invillia.account.factory;

import br.com.leonardoferreira.jbacon.JBacon;
import com.invillia.account.entity.enums.AccountType;
import com.invillia.account.repository.AccountRepository;
import com.invillia.account.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountFactory  extends JBacon<Account> {

  private final AccountRepository accountRepository;
  private final PersonFactory personFactory;


  public AccountFactory(AccountRepository accountRepository, PersonFactory personFactory) {
    this.accountRepository = accountRepository;
    this.personFactory = personFactory;
  }

  @Override
  protected Account getDefault() {

    return Account
            .builder()
            .numberAccount("12345")
            .balance(0.0)
            .loanLimit(0.0)
            .accountType(AccountType.CHECKINGACCOUNT)
            .id(1L)
            .person(personFactory.create())
            .build();
  }

  @Override
  protected Account getEmpty() {
    return new Account();
  }

  @Override
  protected void persist(Account account) {
    accountRepository.save(account);
  }
}
