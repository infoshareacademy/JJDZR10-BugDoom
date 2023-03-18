package com.infoshareacademy.pl.repository;

import com.infoshareacademy.pl.model.User;

public interface UserRepository {
    User findUserById(long userId);
}
