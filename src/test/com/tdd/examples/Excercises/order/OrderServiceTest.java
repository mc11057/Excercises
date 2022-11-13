package com.tdd.examples.Excercises.order;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
@Order(3)
public class OrderServiceTest {

    @BeforeAll
    static void setup(){
        System.out.println("Test methods related to Order Service");
    }
    @Test
    void test(){

    }
}
