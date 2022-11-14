package com.tdd.examples.Excercises.service;

import com.tdd.examples.Excercises.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserServiceTest {
    UserService uservice;
    String firstName;
    String lastName;
    String email;
    String password;
    String repeatPassword;
    String expectedExceptionMessage;

    @BeforeEach
    void init(){
         uservice = new UserServiceImpl();
         firstName="Carlos";
         lastName="martinez";
         email="carlosmar6977@gmail.com";
         password="1234";
         repeatPassword="1234";
    }

    @DisplayName("User object created")
    @Test
    void testCreateUser_WhenUserDetailsIsProvided_returnUserObject(){
        //Act
        User user = uservice.createUser(firstName,lastName,email,password,repeatPassword);
        //Assert
        assertNotNull(user,"The createUser() should not have returned null");
        assertEquals(firstName,user.getFirstName(),"User's firstname is incorrect");
        assertEquals(lastName,user.getLastName(),"User's lastname is incorrect");
        assertEquals(email,user.getEmail(),"User's email is incorrect");
        assertNotNull(user.getId(),"User id is missing");
    }
    @DisplayName("User object is not created because firstName is empty and throws an exception")
    @Test
    void testCreateUser_WhenFirstNameIsEmpty_throwsIllegalArgumentException(){
        //Arrange
        String firstName="";
        String expectedExceptionMessage="User's firstname is empty";
        //Act & Assert
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class,()->{
            uservice.createUser(firstName,lastName,email,password,repeatPassword);
        },"Empty firstName should have caused an Illegal Argument Exception");
        //Assert
        assertEquals(expectedExceptionMessage,thrown.getMessage(),"expected Message is not correct");
    }
}
