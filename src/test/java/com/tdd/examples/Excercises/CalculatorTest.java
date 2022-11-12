package com.tdd.examples.Excercises;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test math operations in Calculator class") // for a better display in the test report
class CalculatorTest {
    Calculator calculator;

    @BeforeAll //this is not a test, is to prepare the resources, for example create database. needs to be static
    static void setup(){
        System.out.println("Executing @BeforeAll method");
    }

    @AfterAll//this is not a test is to release the resources, for example delete the database.needs to be static
    static void cleanup(){
        System.out.println("Executing @AfterAll method");
    }
    @BeforeEach
    void beforeEachMethod(){
        System.out.println("Executing before each method");
        calculator = new Calculator();
    }
    @AfterEach
    void afterEachMethod(){
        System.out.println("Executing after each method");
    }

    @DisplayName("Test 4/2 =2")
    @Test
    void testIntegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo() {
        //AAA: main sections of Unit tests

        //Arrange:Given: Prepare all the objects need it by the test

        int dividend=4;
        int divisor=2;
        int expectedResult=2;

        //Act:When
        int actualResult = calculator.integerDivision(dividend, divisor);

        //Assert:Then: Validate the expected and actual result
        assertEquals(expectedResult, actualResult, "4/2 did not produce 2");
    }

    //@Disabled("Still need to work on it")
    @DisplayName("Division by zero")
    @Test
    void testIntegerDivision_WhenDividendByZero_ShouldThrowArithmeticException() {
        int dividend = 4;
        int divisor = 0;
        String expectedExceptionMessage = "/ by zero";
        ArithmeticException actualException = assertThrows(ArithmeticException.class,()->{
            calculator.integerDivision(dividend,divisor);
        },"Division by zero should have thrown an Arithmetic exception");
        assertEquals(expectedExceptionMessage,actualException.getMessage(),"Unexpected exception message");
    }

    @DisplayName("Test 4-2 =2")
    @Test
    void integerSubtraction() {
        int result = calculator.integerSubtraction(4, 2);
        assertEquals(2, result, () -> "4-2 did not produce 2"); //use lambda for lazy initialization for the message, will be executed only if the test fail
    }


}