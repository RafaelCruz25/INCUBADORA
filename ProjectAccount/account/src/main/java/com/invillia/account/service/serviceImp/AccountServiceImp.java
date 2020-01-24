package com.invillia.account.service.serviceImp;

import com.invillia.account.entity.Account;
import com.invillia.account.entity.request.AccountRequest;
import com.invillia.account.entity.request.DepositRequest;
import com.invillia.account.entity.request.WithdrawRequest;
import com.invillia.account.entity.response.AccountResponse;
import com.invillia.account.exceptions.AccountNotFoundException;
import com.invillia.account.exceptions.PersonNotFoundException;
import com.invillia.account.exceptions.UnavailableValueException;
import com.invillia.account.exceptions.ValueMustBePositiveException;
import com.invillia.account.mapper.AccountMapper;
import com.invillia.account.repository.AccountRepository;
import com.invillia.account.repository.PersonRepository;
import com.invillia.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImp implements AccountService {

  private final AccountRepository accountRepository;
  private final PersonRepository personRepository;
  private final AccountMapper accountMapper;

  @Autowired
  public AccountServiceImp(AccountRepository accountRepository, PersonRepository personRepository, AccountMapper accountMapper) {
    this.accountRepository = accountRepository;
    this.personRepository = personRepository;
    this.accountMapper = accountMapper;
  }

  @Transactional
  public AccountResponse withdraw(final WithdrawRequest withdrawRequest) {

    if (withdrawRequest.getWithdraw() > 00.00) {
      final Account account = accountRepository.findById(withdrawRequest.getIdAccount())
              .orElseThrow(() -> new AccountNotFoundException("Conta com id" + withdrawRequest.getIdAccount() + "não encontrada"));

      if (account.getAccountType().equals("CHECKINGACCOUNT")) {
        if (account.getBalance() >= 0 && (account.getBalance() + account.getLoanLimit()) >= withdrawRequest.getWithdraw()) {
          account.setBalance(account.getBalance() - withdrawRequest.getWithdraw());
        } else {
          throw new UnavailableValueException("Saldo indisponivel, favor verificar");
        }
      }
      if (account.getAccountType().equals("SAVINGSACCOUNT")) {
        if (account.getBalance() > 0 && (account.getBalance() >= withdrawRequest.getWithdraw())) {
          account.setBalance(account.getBalance() - withdrawRequest.getWithdraw());
        } else {
          throw new UnavailableValueException("Saldo indisponivel, favor verificar");
        }
      }

      final Account accountSaved = accountRepository.save(account);
      return accountMapper.accountToAccountResponse(accountSaved);

    } else {
      throw new ValueMustBePositiveException("Valor sacado não deve ser negativo");
    }
  }

  @Transactional
  public AccountResponse deposit(final DepositRequest depositRequest) {

    if(depositRequest.getDeposit() > 00.00){
      final Account account = accountRepository.findById(depositRequest.getIdAccount())
              .orElseThrow(() -> new AccountNotFoundException("Conta com id "+ depositRequest.getIdAccount() +" não encontrada!"));

      account.setBalance(account.getBalance() + depositRequest.getDeposit());

      final Account accountSaved = accountRepository.save(account);

      return accountMapper.accountToAccountResponse(accountSaved);
    }
    else{
      throw new ValueMustBePositiveException("O valor para depósito não pode ser negativo");
    }
  }

  @Transactional(readOnly = true)
  public List<AccountResponse> findAll(final AccountRequest accountRequest) {
    final List<Account> accounts = accountRepository.findAll();
    return accountMapper.accountToAccountResponse(accounts);
  }

  @Transactional(readOnly = true)
  public AccountResponse findById(final Long id) {
    return accountRepository.findById(id)
            .map(accountMapper::accountToAccountResponse)
            .orElseThrow(() -> new AccountNotFoundException("Conta com id " + id + " não encontrada"));

  }

  @Transactional
  public void update(final Long id, final AccountRequest accountRequest) {
    final Account account = accountRepository.findById(id)
            .orElseThrow(() -> new AccountNotFoundException("Conta com id " + id + " não encontrada!"));

    accountMapper.updateAccountByAccountRequest(account,accountRequest);

    account.setPerson(personRepository.findById(accountRequest.getIdPerson())
            .orElseThrow(()-> new PersonNotFoundException("Pessoa com id "+ id +" não encontrada!")));

    accountRepository.save(account);
  }

  @Transactional
  public void delete(final Long id) {
    final Account account = accountRepository.findById(id)
            .orElseThrow(() -> new AccountNotFoundException("Conta com id " + id + " não encontrada!"));

    accountRepository.delete(account);
  }

  @Transactional
  public Long create(final AccountRequest accountRequest) {

    final Account account = accountMapper.accountRequestToAccount(accountRequest);

    account.setPerson(personRepository.findById(accountRequest.getIdPerson())
            .orElseThrow(()-> new PersonNotFoundException("Pessoa com id " + accountRequest.getIdPerson() + " não encontrada!")));

    final Account accountSaved = accountRepository.save(account);

    return accountSaved.getId();
  }
}
