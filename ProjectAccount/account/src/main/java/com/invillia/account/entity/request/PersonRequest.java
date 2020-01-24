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
public class PersonRequest {

  @NotNull
  @NotBlank
  private String cpf;

  @NotNull
  @NotBlank
  private String name;
}
