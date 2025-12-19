package com.revature.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT) //not necessary bc of global exception handler
public class BookNotAvailableException extends RuntimeException{
    public BookNotAvailableException(String message) {
        super(message); // custom error message
    }
}
