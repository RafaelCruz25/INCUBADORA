package com.invillia.account.service;

import com.invillia.account.entity.request.AccountRequest;
import com.invillia.account.entity.request.DepositRequest;
import com.invillia.account.entity.request.WithdrawRequest;
import com.invillia.account.entity.response.AccountResponse;

import java.util.List;

public interface AccountService {

  AccountResponse withdraw(WithdrawRequest withdrawRequest);

  AccountResponse deposit(DepositRequest depositRequest);

  List<AccountResponse> findAll(final AccountRequest accountRequest);

  AccountResponse findById(final Long id);

  void update(final Long id, final AccountRequest accountRequest);

  void delete(final Long id);

  Long create(final AccountRequest accountRequest);
}
