package com.invillia.account.mapper;

import com.invillia.account.entity.Person;
import com.invillia.account.entity.Account;
import com.invillia.account.entity.enums.AccountType;
import com.invillia.account.entity.request.AccountRequest;
import com.invillia.account.entity.response.AccountResponse;
import com.invillia.account.exceptions.AccountNotFoundException;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountMapper {

  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

  public AccountResponse accountToAccountResponse(final Account account){

    return AccountResponse.builder()
            .id(account.getId())
            .balance(account.getBalance())
            .accountType(String.valueOf(account.getAccountType()))
            .numberAccount(account.getNumberAccount())
            .loanLimit(account.getLoanLimit())
            .person(account.getPerson())
            .createdAt(account.getCreatedAt().format(formatter))
            .updatedAt(account.getUpdatedAt().format(formatter))
            .build();
  }

  public Account accountRequestToAccount(final AccountRequest accountRequest) {

    final Account account = new Account();

    account.setLoanLimit(accountRequest.getLoanLimit());
    account.setBalance(accountRequest.getBalance());
    account.setNumberAccount(accountRequest.getNumberAccount());

    if(accountRequest.getIdPerson() != null){
      Person person = new Person();
      person.setId(accountRequest.getIdPerson());
      account.setPerson(person);
    }

    if(accountRequest.getAccountType() != null && !accountRequest.getAccountType().isBlank()){
      try {
        account.setAccountType(AccountType.valueOf(accountRequest.getAccountType()));
      }catch (Exception e){
        throw new AccountNotFoundException("Tipo de conta inválido: " +e.getMessage());
      }
    }
    return account;
  }

  public List<AccountResponse> accountToAccountResponse(final List<Account> accounts){
    return accounts.stream()
            .map(this::accountToAccountResponse)
            .collect(Collectors.toList());
  }

  public void updateAccountByAccountRequest(final Account account, final AccountRequest accountRequest){
    account.setNumberAccount(accountRequest.getNumberAccount());
    account.setLoanLimit(accountRequest.getLoanLimit());
    account.setAccountType(AccountType.valueOf(accountRequest.getAccountType()));
    account.setBalance(accountRequest.getBalance());

  }
}
