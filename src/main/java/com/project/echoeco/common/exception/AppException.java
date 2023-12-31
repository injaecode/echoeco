package com.project.echoeco.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AppException extends RuntimeException {

  public AppException(ErrorCode unknownMember) {
  }

  private ErrorCode errorCode;
  private String message;
}
