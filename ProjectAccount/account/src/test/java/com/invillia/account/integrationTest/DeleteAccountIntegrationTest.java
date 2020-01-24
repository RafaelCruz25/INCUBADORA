package com.invillia.account.integrationTest;

import com.invillia.account.factory.AccountFactory;
import com.invillia.account.repository.AccountRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_NO_CONTENT;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DeleteAccountIntegrationTest {

  private final AccountFactory accountFactory;
  private final AccountRepository accountRepository;

  @Autowired
  public DeleteAccountIntegrationTest(final AccountFactory accountFactory,final AccountRepository accountRepository) {
    this.accountFactory = accountFactory;
    this.accountRepository = accountRepository;
  }

  @Test
  void deleteWithSuccessTest(){
    accountFactory.create();

    RestAssured
            .given()
              .log().all()
            .when()
              .delete("/accounts/1")
            .then()
              .log().all()
              .statusCode(SC_NO_CONTENT);

    Assertions.assertEquals(0, accountRepository.count());
  }

  @Test
  void deleteWithoutSuccessTest(){
    RestAssured
            .given()
              .log().all()
            .when()
              .delete("/accounts/1")
            .then()
              .log().all()
              .statusCode(SC_BAD_REQUEST);
  }
}
