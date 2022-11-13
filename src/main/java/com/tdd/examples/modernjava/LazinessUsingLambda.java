package com.tdd.examples.modernjava;

import java.util.function.Supplier;

class Lazy<T> {
    private T instance;
    private Supplier<T> supplier;

    public Lazy(Supplier<T> supplier) {
        this.supplier = supplier; //this make the function lazy
    }

    public T get() {
        if (instance == null)
            instance = supplier.get();
        return instance;
    }
}
public class LazinessUsingLambda {

    public static void main(String[] args) {
        /*
            Lazy evaluation is to Functional Programming
            as polymorphism is to OOP.

            In procedural code, pointers gave the power of indirection
            In OOP, overriding functions gave the power of indirection
            In FP, lambdas give the power of indirection
         */
        int value = 4;
        //int temp = compute(value); //Eager evaluation.Here it was called (because value is 4) even though we will not use it
        Lazy<Integer> temp = new Lazy(() -> compute(value));//Lazy evaluation
        //temp.get() This is the point where I really need the value
        if (value > 4 && temp.get() > 100) {// short-circuiting
            System.out.println("path 1 with " + temp.get());
        } else {
            System.out.println("path 2");
        }

    }
    public static int compute(int number) {
        //imagine takes some time to compute
        return number * 100;
    }



}
