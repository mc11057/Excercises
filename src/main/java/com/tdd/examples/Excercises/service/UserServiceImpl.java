package com.tdd.examples.Excercises.service;

import com.tdd.examples.Excercises.model.User;

import java.util.UUID;

public class UserServiceImpl implements UserService {
    @Override
    public User createUser(String firstName, String lastName, String email, String password, String repeatPassword) {
        if(firstName == null || firstName.isEmpty())
            throw new IllegalArgumentException("User's firstname is empty");
        return new User(firstName,lastName,email,password,repeatPassword, UUID.randomUUID().toString());
    }
}
