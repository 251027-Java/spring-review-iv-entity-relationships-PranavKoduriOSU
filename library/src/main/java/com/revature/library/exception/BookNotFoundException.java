package com.revature.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) //not necessary bc of global exception handler
public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message) {
        super(message); // custom error message
    }
}
