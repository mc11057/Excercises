package com.tdd.examples.Excercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DemoRepeatedTest {
    Calculator calculator;

    @BeforeEach
    void beforeEachMethod() {
        System.out.println("Executing before each method");
        calculator = new Calculator();
    }


    @DisplayName("Division by zero")
    @RepeatedTest(3)//execute the test several times
    void testIntegerDivision_WhenDividendByZero_ShouldThrowArithmeticException() {
        int dividend = 4;
        int divisor = 0;
        String expectedExceptionMessage = "/ by zero";
        ArithmeticException actualException = assertThrows(ArithmeticException.class, () -> {
            calculator.integerDivision(dividend, divisor);
        }, "Division by zero should have thrown an Arithmetic exception");
        assertEquals(expectedExceptionMessage, actualException.getMessage(), "Unexpected exception message");
    }
}
