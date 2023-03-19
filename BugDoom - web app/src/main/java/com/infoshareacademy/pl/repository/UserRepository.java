package com.infoshareacademy.pl.repository;

import com.infoshareacademy.pl.model.User;

import java.io.IOException;

public interface UserRepository {
    User findUserById(long userId) throws IOException;
}
