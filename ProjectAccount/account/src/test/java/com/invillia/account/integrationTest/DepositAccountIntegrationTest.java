package com.invillia.account.integrationTest;

import com.invillia.account.entity.request.BankRequest;
import com.invillia.account.factory.AccountFactory;
import com.invillia.account.entity.Account;
import com.invillia.account.repository.AccountRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_NOT_ACCEPTABLE;
import static org.apache.http.HttpStatus.SC_OK;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DepositAccountIntegrationTest {

  private final AccountFactory accountFactory;
  private final AccountRepository accountRepository;

  @Autowired
  public DepositAccountIntegrationTest(AccountFactory accountFactory, AccountRepository accountRepository) {
    this.accountFactory = accountFactory;
    this.accountRepository = accountRepository;
  }

  @Test
  void depositWithIdPersonNotExistTest(){
    final Account account = accountFactory.create();
    final BankRequest bankRequest = new BankRequest(500.00);

    RestAssured
            .given()
              .log().all()
              .contentType(ContentType.JSON)
              .body(bankRequest)
            .when()
              .post("/accounts/deposit")
            .then()
              .log().all()
              .statusCode(SC_BAD_REQUEST)
              .body("message", Matchers.is("Conta com id 2 não encontrada!"));
  }

  @Test
  void depositWithSuccessTest(){
    final Account account = accountFactory.create();
    final BankRequest bankRequest = new BankRequest(500.00);
    final Double balance = bankRequest.getValue() + account.getBalance();

    RestAssured
            .given()
              .log().all()
              .contentType(ContentType.JSON)
              .body(bankRequest)
            .when()
              .post("/accounts/deposit")
            .then()
              .log().all()
              .statusCode(SC_OK);

    Account accountDeposit = accountRepository.findById(1L).get();

    Assertions.assertAll("account assert",
            () -> Assertions.assertEquals(balance, accountDeposit.getBalance()));
  }

  @Test
  void depositAccountWithNegativeNumberTest(){
    final Account account = accountFactory.create();

    final BankRequest bankRequest = new BankRequest(-2000.00);

    RestAssured
            .given()
              .log().all()
              .contentType(ContentType.JSON)
              .body(bankRequest)
            .when()
              .post("/accounts/deposit")
            .then()
              .log().all()
              .statusCode(SC_NOT_ACCEPTABLE)
              .body("message", Matchers.is("O valor para depósito não pode ser negativo"));

    Account accountDeposit = accountRepository.findById(1L).get();

    Assertions.assertAll("account assert",
            () -> Assertions.assertEquals(account.getBalance(), accountDeposit.getBalance()));
  }
}
