package com.invillia.account.entity.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepositRequest {

  @NotNull
  private Double deposit;

  @NotNull
  private Long idAccount;
}
