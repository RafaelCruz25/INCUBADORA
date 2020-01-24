package com.invillia.account.integrationTest;

import com.invillia.account.entity.Account;
import com.invillia.account.entity.request.BankRequest;
import com.invillia.account.factory.AccountFactory;
import com.invillia.account.repository.AccountRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static javax.servlet.http.HttpServletResponse.SC_NOT_ACCEPTABLE;
import static javax.servlet.http.HttpServletResponse.SC_OK;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class WithdrawAccountIntegrationTest {

  private final AccountFactory accountFactory;

  private final AccountRepository accountRepository;

  @Autowired
  public WithdrawAccountIntegrationTest(AccountFactory accountFactory, AccountRepository accountRepository) {
    this.accountFactory = accountFactory;
    this.accountRepository = accountRepository;
  }

  @Test
  void mustWithdrawAccountWithIdPersonWithoutSuccessTest() {

    accountFactory.create();

    BankRequest bankRequest = new BankRequest(500.00);

    RestAssured
            .given()
              .log().all()
              .contentType(ContentType.JSON)
            .body(bankRequest)
              .when()
              .post("/accounts/withdraw/1")
            .then()
              .log().all()
              .statusCode(SC_NOT_ACCEPTABLE)
            .body("message", Matchers.is("Saldo indisponivel, favor verificar"));

  }


  @Test
  void mustWhithdrawAccountWithSuccessTest() {

    final Account account = accountFactory.create();

    BankRequest bankRequest = new BankRequest(200.00);

    final Double balance = account.getBalance() - bankRequest.getValue();

    RestAssured
            .given()
              .log().all()
              .contentType(ContentType.JSON)
              .body(bankRequest)
            .when()
              .post("/accounts/withdraw/1")
            .then()
              .log().all()
              .statusCode(SC_OK);

    final Account withdrawAccount = accountRepository.findById(1L).get();

    Assertions.assertAll("account assert",
            () -> Assertions.assertEquals(balance, withdrawAccount.getBalance()));
  }


  @Test
  void mustWithdrawLimitWithoutSuccessTest() {

    final Account account = accountFactory.create();

    BankRequest bankRequest = new BankRequest(2000.00);

    RestAssured
            .given()
              .log().all()
              .contentType(ContentType.JSON)
              .body(bankRequest)
            .when()
              .post("/accounts/withdraw/1")
            .then()
              .log().all()
              .statusCode(SC_NOT_ACCEPTABLE);

    final Account accountWithWithdraw = accountRepository.findById(1L).get();

    Assertions.assertAll("account assert",
            () -> Assertions.assertEquals(account.getBalance(), accountWithWithdraw.getBalance()));
  }


  @Test
  void mustWithdrawAccountWithNegativeNumber() {

    final Account account = accountFactory.create();

    BankRequest bankRequest = new BankRequest(-200.00);

    RestAssured
            .given()
              .log().all()
              .contentType(ContentType.JSON)
              .body(bankRequest)
            .when()
              .post("/accounts/withdraw/1")
            .then()
              .log().all()
              .statusCode(SC_NOT_ACCEPTABLE);


    final Account accountWithWithdraw = accountRepository.findById(1L).get();

    Assertions.assertAll("account assert",
            () -> Assertions.assertEquals(account.getBalance(), accountWithWithdraw.getBalance()));
  }

}
