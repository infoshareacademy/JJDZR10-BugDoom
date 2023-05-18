package com.infoshareacademy.pl.exception;

import org.apache.logging.log4j.LogManager;

import java.util.logging.Logger;

public class EventNotFoundException extends RuntimeException {
    private static final Logger logger = (Logger) LogManager.getLogger(EventNotFoundException.class);
    public EventNotFoundException(String message) {
        super(message);
        logger.warning("Nie znaleziono wydarzenia: {}");
    }
}
