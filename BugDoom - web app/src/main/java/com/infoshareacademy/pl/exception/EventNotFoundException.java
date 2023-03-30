package com.infoshareacademy.pl.exception;

import java.util.NoSuchElementException;

public class EventNotFoundException extends NoSuchElementException {
    public EventNotFoundException(String message){
        super(message);
    }
}
