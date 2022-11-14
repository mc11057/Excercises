package com.tdd.examples.Excercises.model;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String repeatPassword;
    private String id;

    public User(String firstName, String lastName, String email, String password, String repeatPassword,String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.id=id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }
}
