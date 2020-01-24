package com.invillia.account.entity.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest {

  @NotNull
  @NotBlank
  private String numberAccount;

  @NotNull
  private Double balance;

  @NotNull
  private Double loanLimit;

  @NotNull
  @NotBlank
  private String accountType;

  @NotNull
  private Long idPerson;
}
