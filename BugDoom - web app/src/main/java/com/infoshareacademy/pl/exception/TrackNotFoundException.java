package com.infoshareacademy.pl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class TrackNotFoundException extends RuntimeException {
    public TrackNotFoundException(String message){
        super(message);
    }
}
