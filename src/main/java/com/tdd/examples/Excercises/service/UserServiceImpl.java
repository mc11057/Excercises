package com.tdd.examples.Excercises.service;

import com.tdd.examples.Excercises.data.UserRepository;
import com.tdd.examples.Excercises.model.User;

import java.util.UUID;

public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    EmailVerificationService emailVerificationService;

    public UserServiceImpl(UserRepository userRepository,EmailVerificationService emailVerificationService) {
        this.userRepository = userRepository;
        this.emailVerificationService = emailVerificationService;
    }

    @Override
    public User createUser(String firstName, String lastName, String email, String password, String repeatPassword) {
        if(firstName == null || firstName.isEmpty())
            throw new IllegalArgumentException("User's firstname is empty");
        User user = new User(firstName,lastName,email,password,repeatPassword, UUID.randomUUID().toString());
        boolean isUserCreated;
        try {
            isUserCreated = userRepository.save(user);
        }catch (Exception e){
            throw new UserServiceException("Could not create user");
        }

        if(!isUserCreated)
            throw new UserServiceException("Could not create user");
        try{
            emailVerificationService.scheduleEmailConfirmation(user);
        }catch (RuntimeException ex){
            throw new UserServiceException(ex.getMessage());

        }

        return user;
    }
}
