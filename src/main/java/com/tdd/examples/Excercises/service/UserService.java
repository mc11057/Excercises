package com.tdd.examples.Excercises.service;

import com.tdd.examples.Excercises.model.User;

public interface UserService {
    User createUser(String firstName, String lastName, String email, String password, String repeatPassword);
}
