package com.tdd.examples.Excercises.service;

import com.tdd.examples.Excercises.data.UserRepository;
import com.tdd.examples.Excercises.data.UserRepositoryImpl;
import com.tdd.examples.Excercises.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)//enable us for use mockito annotations in our class
public class UserServiceTest {

    @InjectMocks
    UserServiceImpl userService;
    @Mock
    UserRepositoryImpl userRepository;
    @Mock
    EmailVerificationServiceImpl emailVerificationService;
    String firstName;
    String lastName;
    String email;
    String password;
    String repeatPassword;

    @BeforeEach
    void init(){
         firstName="Carlos";
         lastName="martinez";
         email="carlosmar6977@gmail.com";
         password="1234";
         repeatPassword="1234";
    }

    @DisplayName("User object created")
    @Test
    void testCreateUser_WhenUserDetailsIsProvided_returnUserObject(){
        //Arrange
        when(userRepository.save(any(User.class))).thenReturn(true);
        //Act
        User user = userService.createUser(firstName,lastName,email,password,repeatPassword);
        //Assert
        assertNotNull(user,"The createUser() should not have returned null");
        assertEquals(firstName,user.getFirstName(),"User's firstname is incorrect");
        assertEquals(lastName,user.getLastName(),"User's lastname is incorrect");
        assertEquals(email,user.getEmail(),"User's email is incorrect");
        assertNotNull(user.getId(),"User id is missing");
        verify(userRepository,times(1)).save(any(User.class));//to verify how many times the method was called
        //or         verify(userRepository).save(any(User.class));//when times is One we can omit times(1). Is the default value
    }
    @DisplayName("User object is not created because firstName is empty and throws an exception")
    @Test
    void testCreateUser_WhenFirstNameIsEmpty_throwsIllegalArgumentException(){
        //Arrange
        String firstName="";
        String expectedExceptionMessage="User's firstname is empty";
        //Act & Assert
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class,()->{
            userService.createUser(firstName,lastName,email,password,repeatPassword);
        },"Empty firstName should have caused an Illegal Argument Exception");
        //Assert
        assertEquals(expectedExceptionMessage,thrown.getMessage(),"expected Message is not correct");
    }
    @DisplayName("If save() method causes RuntimeException, a UserviceException is thrown")
    @Test
    void testCreateUser_WhenUserSaveMethodThrowsException_thenThrowUserServiceException(){
        //Arrange
        when(userRepository.save(any(User.class))).thenThrow(RuntimeException.class);
        //Act
        assertThrows(UserServiceException.class,() -> {
            userService.createUser(firstName,lastName,email,password,repeatPassword);
        },"Should have thrown UserServiceException instead");
    }

    @DisplayName("EmailNotificationException is handled")
    @Test
    void testCreateUser_WhenEmailNotificationExceptionThrown_thenThrowUserServiceException(){
        //Arrange
        when(userRepository.save(any(User.class))).thenReturn(true);
        //handling exception for void method is different, we use:
        doThrow(EmailNotificationServiceException.class).when(emailVerificationService).scheduleEmailConfirmation(any(User.class));
        //Act && Assert
        assertThrows(UserServiceException.class,() -> {
            userService.createUser(firstName,lastName,email,password,repeatPassword);
        },"Should have thrown UserServiceException instead");
        verify(emailVerificationService).scheduleEmailConfirmation(any(User.class));
    }

    //Do nothing example
    @DisplayName("Do nothing example")
    @Test
    void testCreateUser_WhenDoNothing_thenCreateUser(){
        //Arrange
        when(userRepository.save(any(User.class))).thenReturn(true);
        //handling exception for void method is different, we use:
        doNothing().when(emailVerificationService).scheduleEmailConfirmation(any(User.class));
        //Act
        User user = userService.createUser(firstName,lastName,email,password,repeatPassword);
        //Assert
        assertNotNull(user,"The createUser() should not have returned null");
        assertEquals(firstName,user.getFirstName(),"User's firstname is incorrect");
        assertEquals(lastName,user.getLastName(),"User's lastname is incorrect");
        assertEquals(email,user.getEmail(),"User's email is incorrect");
        assertNotNull(user.getId(),"User id is missing");
        verify(userRepository,times(1)).save(any(User.class));//to verify how many times the method was called
    }

    @DisplayName("Schedule Email Confirmation is executed (Real Call)")
    @Test
    void testCreateUser_WhenUserCreated_scheduleEmailConfirmation(){
        //Arrange
        when(userRepository.save(any(User.class))).thenReturn(true);
        //handling exception for void method is different, we use:
        doCallRealMethod().when(emailVerificationService).scheduleEmailConfirmation(any(User.class));
        //Act
        userService.createUser(firstName,lastName,email,password,repeatPassword);
        //Assert
        verify(emailVerificationService,times(1)).scheduleEmailConfirmation(any(User.class));
    }
    /*
    Assert a list
        List<String> numbers = Arrays.asList("one", "two", "three");
        List<String> numbers2 = Arrays.asList("one", "two", "three");
        Assertions.assertArrayEquals(numbers.toArray(), numbers2.toArray());
     */
}
