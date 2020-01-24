package com.invillia.account.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonSaveRequest {

  @NotBlank
  private String name;

  @NotBlank
  private String cpf;
}
