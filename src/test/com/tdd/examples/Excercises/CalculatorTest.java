package com.tdd.examples.Excercises;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test math operations in Calculator class") // for a better display in the test report
class CalculatorTest {
    Calculator calculator;

    @BeforeAll //this is not a test, is to prepare the resources, for example create database. needs to be static
    static void setup() {
        System.out.println("Executing @BeforeAll method");
    }

    @AfterAll//this is not a test is to release the resources, for example delete the database.needs to be static
    static void cleanup() {
        System.out.println("Executing @AfterAll method");
    }


    @BeforeEach
    void beforeEachMethod() {
        System.out.println("Executing before each method");
        calculator = new Calculator();
    }

    @AfterEach
    void afterEachMethod() {
        System.out.println("Executing after each method");
    }

    @DisplayName("Test 4/2 =2")
    @Test
    void testIntegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo() {
        //AAA: main sections of Unit tests

        //Arrange:Given: Prepare all the objects need it by the test

        int dividend = 4;
        int divisor = 2;
        int expectedResult = 2;

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
        ArithmeticException actualException = assertThrows(ArithmeticException.class, () -> {
            calculator.integerDivision(dividend, divisor);
        }, "Division by zero should have thrown an Arithmetic exception");
        assertEquals(expectedExceptionMessage, actualException.getMessage(), "Unexpected exception message");
    }

    @DisplayName("Test integer subtraction [minuend, subtrahend,expectedResult]")
    @ParameterizedTest //The test can accept parameters
    @MethodSource()
//this is like the method to get the arguments
    void testIntegerSubtraction_WhenTwoIsSubtractedFromFour_ShouldTRReturnTwo(int minuend, int subtrahend, int expectedResult) {
        int result = calculator.integerSubtraction(minuend, subtrahend);
        assertEquals(expectedResult, result, () -> "4-2 did not produce 2"); //use lambda for lazy initialization for the message, will be executed only if the test fail
    }

    public static Stream<Arguments> testIntegerSubtraction_WhenTwoIsSubtractedFromFour_ShouldTRReturnTwo() {
        return Stream.of(
                Arguments.of(33, 1, 32),
                Arguments.of(54, 1, 53),
                Arguments.of(24, 1, 23)
        );
    }

    //this is another approach (seed of parameters)
    @DisplayName("Test integer subtraction2 [minuend, subtrahend,expectedResult]")
    @ParameterizedTest //The test can accept parameters
    @CsvSource({
            "33,1,32",
            "34,1,33",
            "54,1,53"

    })
    void testIntegerSubtraction_WhenTwoIsSubtractedFromFour_ShouldTRReturnTwo2(int minuend, int subtrahend, int expectedResult) {
        int result = calculator.integerSubtraction(minuend, subtrahend);
        assertEquals(expectedResult, result, () -> "4-2 did not produce 2"); //use lambda for lazy initialization for the message, will be executed only if the test fail
    }

    //this is another approach (seed of parameters through file) This can be used for a large set of data
    @DisplayName("Test integer subtraction3 [minuend, subtrahend,expectedResult]")
    @ParameterizedTest //The test can accept parameters
    @CsvFileSource(resources = "/integerSubtraction.csv")
    void testIntegerSubtraction_WhenTwoIsSubtractedFromFour_ShouldTRReturnTwo3(int minuend, int subtrahend, int expectedResult) {
        int result = calculator.integerSubtraction(minuend, subtrahend);
        assertEquals(expectedResult, result, () -> "4-2 did not produce 2"); //use lambda for lazy initialization for the message, will be executed only if the test fail
    }

    @ParameterizedTest
    @ValueSource(strings = {"John", "Carlos", "Antonella"})//let us supply one single parameter
    void valueSourceDemonstration(String firstName) {
        System.out.println(firstName);
        assertNotNull(firstName);
    }

    //this is another approach to accept string
    @DisplayName("Test integer subtraction2 [minuend, subtrahend,expectedResult]")
    @ParameterizedTest //The test can accept parameters
    @CsvSource({
            "apple,orange",
            "apple,''", //second parameter is empty
            "apple," //second parameter is null

    })
    void testToAcceptStringParameters3(String firstParameter, String secondParameter) {
        System.out.println(firstParameter + " " + secondParameter);
    }


}