package com.tdd.examples.Excercises.service;

import com.tdd.examples.Excercises.model.User;

public interface EmailVerificationService {
    void scheduleEmailConfirmation(User user);
}
