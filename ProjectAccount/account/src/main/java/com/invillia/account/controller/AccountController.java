package com.invillia.account.controller;

import com.invillia.account.entity.request.AccountRequest;
import com.invillia.account.entity.request.DepositRequest;
import com.invillia.account.entity.request.WithdrawRequest;
import com.invillia.account.entity.response.AccountResponse;
import com.invillia.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

  private final AccountService accountService;

  @Autowired
  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @PostMapping("/withdraw")
  public ResponseEntity withdraw(@Valid @RequestBody final WithdrawRequest withdrawRequest){
    accountService.withdraw(withdrawRequest);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/deposit")
  public ResponseEntity deposit(@Valid @RequestBody final DepositRequest depositRequest){
    accountService.deposit(depositRequest);
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public ResponseEntity findAll(
          @RequestParam(value = "numberAccount", required = false) String numberAccount,
          @RequestParam(value = "balance", required = false) Double balance,
          @RequestParam(value = "accountType", required = false) String accountType,
          @RequestParam(value = "loanLimit", required = false) Double loanLimit,
          @RequestParam(value = "idPerson", required = false) Long idPerson
          ){
    AccountRequest accountRequest = new AccountRequest();
    accountRequest.setNumberAccount(numberAccount);
    accountRequest.setBalance(balance);
    accountRequest.setAccountType(accountType);
    accountRequest.setLoanLimit(loanLimit);
    accountRequest.setIdPerson(idPerson);

    List<AccountResponse> accountResponseList = accountService.findAll(accountRequest);
    return ResponseEntity.ok(accountResponseList);
  }

  @GetMapping("/{id}")
  public ResponseEntity findById(@PathVariable final Long id){
    AccountResponse accountResponse = accountService.findById(id);
    return ResponseEntity.ok(accountResponse);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable final Long id){
    accountService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity update(@Valid @PathVariable final Long id,
                               @Valid @RequestBody final AccountRequest accountRequest){
    accountService.update(id, accountRequest);
    return ResponseEntity.noContent().build();
  }

  @PostMapping
  public ResponseEntity save(@Valid @RequestBody final AccountRequest accountRequest){
    Long idAccount = accountService.create(accountRequest);

    final URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/accounts/{id}")
            .build(idAccount);

    return ResponseEntity.created(location).build();
  }
}
