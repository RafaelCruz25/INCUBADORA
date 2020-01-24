package com.invillia.account.entity.response;

import com.invillia.account.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {

  private Long id;
  private String numberAccount;
  private Double balance;
  private Double loanLimit;
  private String accountType;
  private Person person;
  private String createdAt;
  private String updatedAt;
}
