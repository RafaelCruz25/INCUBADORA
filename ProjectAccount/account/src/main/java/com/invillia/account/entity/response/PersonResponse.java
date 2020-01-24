package com.invillia.account.entity.response;

import com.invillia.account.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonResponse {

  private Long id;
  private String cpf;
  private String name;
  private List<Account> accountList;
  private String createdAt;
  private String updatedAt;
}
