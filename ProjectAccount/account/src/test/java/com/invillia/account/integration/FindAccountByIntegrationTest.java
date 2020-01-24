package com.invillia.account.integration;

import com.invillia.account.factory.AccountFactory;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static javax.servlet.http.HttpServletResponse.SC_OK;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FindAccountByIntegrationTest {

  private final AccountFactory accountFactory;

  @Autowired
  public FindAccountByIntegrationTest(final AccountFactory accountFactory) {
    this.accountFactory = accountFactory;
  }

  @Test
  void mustFindAllWithSuccessTest(){
    accountFactory.create(2);

    RestAssured
            .given()
              .log().all()
            .when()
              .get("/accounts")
            .then()
              .log().all()
              .statusCode(SC_OK)
              .body("$", Matchers.hasSize(2));
  }
}
