package com.infoshareacademy.pl.repository;

import com.infoshareacademy.pl.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.IOException;

public interface UserRepository extends JpaRepository {
    User findUserById(long userId);
}
