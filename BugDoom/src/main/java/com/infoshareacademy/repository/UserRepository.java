package com.infoshareacademy.repository;

import com.infoshareacademy.model.User;

public interface UserRepository {
    // tutaj będą wszystkie metody do klas serwisowych (logiki biznesowej)
    User findUserById (String id);
}
