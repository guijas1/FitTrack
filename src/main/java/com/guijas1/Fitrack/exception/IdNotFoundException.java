package com.guijas1.Fitrack.exception;


import org.springframework.http.HttpStatus;

public class IdNotFoundException extends RuntimeException {

    private final HttpStatus status;

    public IdNotFoundException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus(){
        return status;
    }
}
