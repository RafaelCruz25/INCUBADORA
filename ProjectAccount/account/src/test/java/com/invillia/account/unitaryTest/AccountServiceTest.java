package com.invillia.account.unitaryTest;

import com.invillia.account.entity.Account;
import com.invillia.account.entity.request.AccountRequest;
import com.invillia.account.entity.request.BankRequest;
import com.invillia.account.exceptions.AccountNotFoundException;
import com.invillia.account.exceptions.PersonNotFoundException;
import com.invillia.account.exceptions.ValueMustBePositiveException;
import com.invillia.account.factory.AccountFactory;
import com.invillia.account.factory.AccountRequestFactory;
import com.invillia.account.repository.AccountRepository;
import com.invillia.account.repository.PersonRepository;
import com.invillia.account.service.serviceImp.AccountServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class AccountServiceTest {

  @MockBean
  private AccountRepository accountRepository;

  @MockBean
  private PersonRepository personRepository;

  @Autowired
  private AccountServiceImp accountService;

  @Autowired
  private AccountFactory accountFactory;

  @Autowired
  private AccountRequestFactory accountRequestFactory;

  @Test
  void mustSaveAccountWithSuccessTest(){
    final AccountRequest accountRequest = accountRequestFactory.build();
    accountRequest.setIdPerson(1L);

    final Account accountFake = accountFactory.build();
    accountFake.setId(1L);
    accountFake.getPerson().setId(1L);

    Mockito.when(personRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(accountFake.getPerson()));
    Mockito.when(accountRepository.save(Mockito.any(Account.class))).thenReturn(accountFake);

    Long id = accountService.create(accountRequest);
    Assertions.assertEquals(1L, id);

    final ArgumentCaptor<Account> captor = ArgumentCaptor.forClass(Account.class);
    Mockito.verify(accountRepository, Mockito.times(1)).save(captor.capture());

    final ArgumentCaptor<Long> captorLong = ArgumentCaptor.forClass(Long.class);
    Mockito.verify(personRepository, Mockito.times(1)).findById(captorLong.capture());
  }

  @Test
  void mustNotSaveAccountWithoutSuccessTest(){
    final AccountRequest accountRequest = accountRequestFactory.build();

    Mockito.when(personRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

    Assertions.assertThrows(PersonNotFoundException.class, () -> {
      accountService.create(accountRequest);
    });

    final ArgumentCaptor<Account> captor = ArgumentCaptor.forClass(Account.class);
    Mockito.verify(accountRepository, Mockito.times(0)).save(captor.capture());

    final ArgumentCaptor<Long> captorLong = ArgumentCaptor.forClass(Long.class);
    Mockito.verify(personRepository, Mockito.times(1)).findById(captorLong.capture());
  }

  @Test
  void mustNotDepositAccountWithNegativeValue() {
    final BankRequest bankRequest = new BankRequest(-200.0);

    Assertions.assertThrows(ValueMustBePositiveException.class, () ->{
      accountService.deposit(1L, bankRequest);
    });

    final ArgumentCaptor<Account> captor = ArgumentCaptor.forClass(Account.class);
    Mockito.verify(accountRepository, Mockito.times(0)).save(captor.capture());

    final ArgumentCaptor<Long> captorLong = ArgumentCaptor.forClass(Long.class);
    Mockito.verify(accountRepository, Mockito.times(0)).findById(captorLong.capture());
  }

  @Test
  void mustNotWithdrawAccountWithNegativeValue(){
    final BankRequest bankRequest = new BankRequest(-200.0);

    Assertions.assertThrows(ValueMustBePositiveException.class, () ->{
      accountService.withdraw(1L, bankRequest);
    });

    final ArgumentCaptor<Account> captor = ArgumentCaptor.forClass(Account.class);
    Mockito.verify(accountRepository, Mockito.times(0)).save(captor.capture());

    final ArgumentCaptor<Long> captorLong = ArgumentCaptor.forClass(Long.class);
    Mockito.verify(accountRepository, Mockito.times(0)).findById(captorLong.capture());
  }
}
