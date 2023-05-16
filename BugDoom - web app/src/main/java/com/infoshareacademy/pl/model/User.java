package com.infoshareacademy.pl.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @NotEmpty(message = "Podaj adres email")
    @Email(message = "Niepoprawny adres email")
    @Column(name = "user_email_address", nullable = false)
    private String userEmailAddress;

    @NotEmpty(message = "Podaj imię i nazwisko")
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty(message = "Podaj hasło")
    @Column(name = "password", nullable = false)
    private String password;

    public User() {
    }

    public User(String userEmailAddress, String password) {
        this.userEmailAddress = userEmailAddress;
        this.password = password;
    }

    public long getUserId() {
        return userId;
    }

    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(userEmailAddress, user.userEmailAddress) && Objects.equals(name, user.name) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userEmailAddress, name, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userEmailAddress='" + userEmailAddress + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';


    }

}
