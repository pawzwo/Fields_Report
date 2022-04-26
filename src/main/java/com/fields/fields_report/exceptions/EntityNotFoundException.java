package com.fields.fields_report.exceptions;

import org.springframework.http.HttpStatus;

public abstract class EntityNotFoundException extends AppException{

    public EntityNotFoundException(String message) {
        super(message + "not found.", HttpStatus.NOT_FOUND);
    }
}
