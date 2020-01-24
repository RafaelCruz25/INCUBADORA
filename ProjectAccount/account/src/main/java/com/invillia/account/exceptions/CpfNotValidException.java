package com.invillia.account.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CpfNotValidException extends RuntimeException {

  private final HttpStatus status;

  public CpfNotValidException(final String message, final HttpStatus status) {
    super(message);
    this.status = status;
  }
}
