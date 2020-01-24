package com.invillia.account.integrationTest;

import com.invillia.account.entity.Account;
import com.invillia.account.entity.request.AccountRequest;
import com.invillia.account.factory.AccountFactory;
import com.invillia.account.factory.AccountRequestFactory;
import com.invillia.account.repository.AccountRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static javax.servlet.http.HttpServletResponse.SC_NO_CONTENT;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UpdateAccountIntegrationTest {

  private final AccountFactory accountFactory;

  private final AccountRepository accountRepository;

  private final AccountRequestFactory accountRequestFactory;

  @Autowired
  public UpdateAccountIntegrationTest(AccountFactory accountFactory,
                                      AccountRepository accountRepository,
                                      AccountRequestFactory accountRequestFactory) {
    this.accountFactory = accountFactory;
    this.accountRepository = accountRepository;
    this.accountRequestFactory = accountRequestFactory;
  }

  @Test
  public void shouldUpdateAccountWithSuccessTest() {

    accountFactory.create();

    final AccountRequest accountRequest = accountRequestFactory.build();

    RestAssured
            .given()
              .log().all()
              .contentType(ContentType.JSON)
              .body(accountRequest)
            .when()
              .put("/accounts/1")
            .then()
              .log().all()
              .statusCode(SC_NO_CONTENT);

    Assertions.assertEquals(1, accountRepository.count());

    final Account account = accountRepository.findById(1L).get();

    Assertions.assertAll("account assert",
            () -> Assertions.assertEquals(accountRequest.getAccountType(), account.getAccountType().toString()),
            () -> Assertions.assertEquals(accountRequest.getBalance(), account.getBalance().doubleValue()),
            () -> Assertions.assertEquals(accountRequest.getLoanLimit(), account.getLoanLimit().doubleValue()),
            () -> Assertions.assertEquals(accountRequest.getIdPerson(), account.getPerson().getId()),
            () -> Assertions.assertEquals(accountRequest.getNumberAccount(), account.getNumberAccount()));
  }
}



