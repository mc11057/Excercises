package com.tdd.examples.modernjava;

import java.util.List;

public class IteratorPattern {

    public static void main(String[] args) {
        var names = List.of("Dory", "Gill", "Bruce", "Nemo", "Darla", "Marlin", "Jacques");
        names.stream()
                .filter(name -> name.length() == 5)
                .map(String::toUpperCase)
                .forEach(System.out::println);
        names.stream()
                .filter(name -> name.length() == 5)
                .map(String::toUpperCase)
                .limit(2)
                //.takeWhile(predicate)
                .forEach(System.out::println);
        //limit and takeWhile are the FP equivalent of break from the imperative style
    }
}
