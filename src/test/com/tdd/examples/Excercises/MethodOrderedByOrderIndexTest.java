package com.tdd.examples.Excercises;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@TestInstance(TestInstance.Lifecycle.PER_METHOD) this is the default behavior
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderedByOrderIndexTest {

    //attribute to show the behaviour
    StringBuilder completed = new StringBuilder();

    @AfterEach
    void afterEach(){
        System.out.println("Final result is "+completed);
    }

    @Order(1)
    @Test
    void TestC(){
        System.out.println("Running test C");
        completed.append("c");
    }
    @Order(2)
    @Test
    void TestA(){
        System.out.println("Running test A");
        completed.append("a");
    }
    @Order(3)
    @Test
    void TestB(){
        System.out.println("Running test B");
        completed.append("b");
    }
}
