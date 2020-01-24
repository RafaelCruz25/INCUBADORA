package com.invillia.account.controller.advice;

import com.invillia.account.exceptions.AccountNotFoundException;
import com.invillia.account.exceptions.CpfNotValidException;
import com.invillia.account.exceptions.PersonNotFoundException;
import com.invillia.account.exceptions.UnavailableValueException;
import com.invillia.account.exceptions.ValueMustBePositiveException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerHandlerException {

  private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

  @ExceptionHandler(AccountNotFoundException.class)
  public HttpEntity<StandardError> accountNotFoundException(final AccountNotFoundException e,
                                                            final HttpServletRequest request){
    HttpStatus status = HttpStatus.BAD_REQUEST;
    StandardError error = new StandardError(
            formatter.format(System.currentTimeMillis()),
            status.value(),
            "Não encontrado!",
            e.getMessage(),
            request.getRequestURI()
    );


    return ResponseEntity.status(status).body(error);
  }

  @ExceptionHandler(CpfNotValidException.class)
  public HttpEntity<StandardError> cpfNotValidException(final CpfNotValidException e,
                                                        final HttpServletRequest request){

    HttpStatus status = HttpStatus.BAD_REQUEST;
    StandardError error = new StandardError(
            formatter.format(System.currentTimeMillis()),
            status.value(),
            "CPF Inválido",
            e.getMessage(),
            request.getRequestURI()
    );
    return ResponseEntity.status(status).body(error);
  }

  @ExceptionHandler(PersonNotFoundException.class)
  public HttpEntity<StandardError> personNotFountException(final PersonNotFoundException e,
                                                           final HttpServletRequest request){
    HttpStatus status = HttpStatus.BAD_REQUEST;
    StandardError error = new StandardError(
            formatter.format(System.currentTimeMillis()),
            status.value(),
            "Não Encontrado!",
            e.getMessage(),
            request.getRequestURI()
    );

    return ResponseEntity.status(status).body(error);
  }

  @ExceptionHandler(UnavailableValueException.class)
  public HttpEntity<StandardError> unavailableValueException(final UnavailableValueException e,
                                                             final HttpServletRequest request){
    HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
    StandardError error = new StandardError(
            formatter.format(System.currentTimeMillis()),
            status.value(),
            "Valor inválido",
            e.getMessage(),
            request.getRequestURI()
    );
    return ResponseEntity.status(status).body(error);
  }

  @ExceptionHandler(ValueMustBePositiveException.class)
  public HttpEntity<StandardError> valueMustBePositiveException(final ValueMustBePositiveException e,
                                                                final HttpServletRequest request){
    HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
    StandardError error = new StandardError(
            formatter.format(System.currentTimeMillis()),
            status.value(),
            "Valor incorreto!",
            e.getMessage(),
            request.getRequestURI()
    );
    return  ResponseEntity.status(status).body(error);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, List<String>>> handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
    final Map<String, List<String>> result = e.getBindingResult().getAllErrors()
            .stream()
            .map(it -> (FieldError) it)
            .collect(
                    Collectors.groupingBy(
                            FieldError::getField,
                            Collectors.mapping(
                                    DefaultMessageSourceResolvable::getDefaultMessage,
                                    Collectors.toList()
                            )
                    )
            );
    return ResponseEntity.badRequest().body(result);
  }
}
