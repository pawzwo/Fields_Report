package com.fields.fields_report.exceptions;

import com.fields.fields_report.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {AppException.class})
    public ResponseEntity<Error> AppException(AppException e) {
        Error error = new Error();
        error.setCode(e.getStatus().value());
        error.setMessage(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.valueOf(error.getCode()));
    }
}
