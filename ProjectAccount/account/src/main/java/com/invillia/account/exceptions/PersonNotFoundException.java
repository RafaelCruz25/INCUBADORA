package com.invillia.account.exceptions;

public class PersonNotFoundException extends RuntimeException {

  public PersonNotFoundException(String message){
    super(message);
  }
}
