package com.tdd.examples.Excercises;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)//by the name of methods
public class MethodsOrderByNameTest {

    @Test
    void TestC(){
        System.out.println("Running test C");
    }

    @Test
    void TestA(){
        System.out.println("Running test A");
    }
    @Test
    void TestB(){
        System.out.println("Running test B");
    }

}
