package com.fields.fields_report.exceptions;

import org.springframework.http.HttpStatus;

public class WrongUserNamePasswordException extends AppException{
    public WrongUserNamePasswordException() {
        super("Wrong User Name or Password", HttpStatus.UNAUTHORIZED);
    }
}

