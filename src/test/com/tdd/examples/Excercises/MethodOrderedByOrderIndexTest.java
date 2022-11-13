package com.tdd.examples.Excercises;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderedByOrderIndexTest {

    @Order(1)
    @Test
    void TestC(){
        System.out.println("Running test C");
    }
    @Order(2)
    @Test
    void TestA(){
        System.out.println("Running test A");
    }
    @Order(3)
    @Test
    void TestB(){
        System.out.println("Running test B");
    }
}
