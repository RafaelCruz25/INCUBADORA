package com.invillia.account.unitaryTest;

import com.invillia.account.factory.AccountFactory;
import com.invillia.account.factory.AccountRequestFactory;
import com.invillia.account.repository.AccountRepository;
import com.invillia.account.repository.PersonRepository;
import com.invillia.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class AccountServiceTest {

  @MockBean
  private AccountRepository accountRepository;

  @MockBean
  private PersonRepository personRepository;

  @Autowired
  private AccountService accountService;

  @Autowired
  private AccountFactory accountFactory;

  @Autowired
  private AccountRequestFactory accountRequestFactory;
}
