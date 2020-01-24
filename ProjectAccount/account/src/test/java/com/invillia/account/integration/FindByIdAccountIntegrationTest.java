package com.invillia.account.integration;

import com.invillia.account.factory.AccountFactory;
import com.invillia.account.entity.Account;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.format.DateTimeFormatter;

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;
import static javax.servlet.http.HttpServletResponse.SC_OK;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
public class FindByIdAccountIntegrationTest {

  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
  private final AccountFactory accountFactory;

  @Autowired
  public FindByIdAccountIntegrationTest(final AccountFactory accountFactory) {
    this.accountFactory = accountFactory;
  }

  @Test
  public void mustFindByIdAccountWithSuccessTest(){
    final Account account = accountFactory.create();

    RestAssured
            .given()
              .log().all()
            .when()
              .get("/accounts/1")
            .then()
              .log().all()
              .statusCode(SC_OK)
              .body("id", Matchers.is(1))
              .body("numberAccount", Matchers.is(account.getNumberAccount()))
              .body("balance", Matchers.is(account.getBalance().floatValue()))
              .body("loanLimit", Matchers.is(account.getLoanLimit().floatValue()))
              .body("accountType", Matchers.is(account.getAccountType().toString()))
              .body("person.id", Matchers.is(account.getPerson().getId().intValue()))
              .body("createdAt", Matchers.is(account.getCreatedAt().format(formatter)))
              .body("updatedAt", Matchers.is(account.getUpdatedAt().format(formatter)));
  }

  @Test
  public void mustFindByIdWithoutSuccessTest(){
      RestAssured
              .given()
                .log().all()
              .when()
                .get("/accounts/1")
              .then()
                .log().all()
                .statusCode(SC_BAD_REQUEST);
  }
}
