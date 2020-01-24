package com.invillia.account.entity.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PersonUpdateRequest {

  @NotBlank
  private String name;

  @NotBlank
  private String cpf;
}
