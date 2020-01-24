package com.invillia.account.controller.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class StandardError {
  private String timestamp;
  private Integer status;
  private String error;
  private String message;
  private String path;
}
