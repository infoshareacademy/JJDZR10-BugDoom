package com.infoshareacademy.pl.exception;

import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class TrackNotFoundException extends RuntimeException {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(TrackNotFoundException.class);
    public TrackNotFoundException(String message) {
        super(message);
        logger.warning("Nie znaleziono trasy: {}");
    }
}
