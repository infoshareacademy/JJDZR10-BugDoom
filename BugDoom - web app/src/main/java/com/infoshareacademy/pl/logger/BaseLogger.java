package com.infoshareacademy.pl.logger;

import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class BaseLogger {
    protected final Logger logger = (Logger) LoggerFactory.getLogger(getClass());
}
