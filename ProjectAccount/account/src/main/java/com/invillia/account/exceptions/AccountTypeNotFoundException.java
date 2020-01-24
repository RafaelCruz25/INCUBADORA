package com.invillia.account.exceptions;

public class AccountTypeNotFoundException extends RuntimeException {
  public AccountTypeNotFoundException(final String message) {
    super(message);
  }
}
