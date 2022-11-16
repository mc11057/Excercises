package com.tdd.examples.Excercises.data;

import com.tdd.examples.Excercises.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {
    Map<String,User> users = new HashMap<>();

    @Override
    public boolean save(User user) {
        if(!users.containsKey(user.getId())){
            return true;
        }
        return false;
    }
}
