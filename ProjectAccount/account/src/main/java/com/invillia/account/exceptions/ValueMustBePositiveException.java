package com.invillia.account.exceptions;

public class ValueMustBePositiveException extends RuntimeException {

  public ValueMustBePositiveException(String message){
    super(message);
  }
}
