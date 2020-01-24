package com.invillia.account.factory;

import br.com.leonardoferreira.jbacon.JBacon;
import com.invillia.account.entity.enums.AccountType;
import com.invillia.account.entity.request.AccountRequest;
import org.springframework.stereotype.Component;

@Component
public class AccountRequestFactory  extends JBacon<AccountRequest> {

  private final PersonFactory personFactory;

  public AccountRequestFactory(PersonFactory personFactory) {
    this.personFactory = personFactory;
  }

  @Override
  protected AccountRequest getDefault() {
    return AccountRequest
            .builder()
            .accountType(AccountType.CHECKINGACCOUNT.toString())
            .balance(0.0)
            .loanLimit(0.0)
            .idPerson(personFactory.create().getId())
            .numberAccount("12345")
            .build();
  }

  @Override
  protected AccountRequest getEmpty() {
    return new AccountRequest();
  }

  @Override
  protected void persist(AccountRequest accountRequest) {
    throw new UnsupportedOperationException();
  }
}
