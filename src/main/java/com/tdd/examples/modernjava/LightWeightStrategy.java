package com.tdd.examples.modernjava;

import java.util.List;
import java.util.function.Predicate;

public class LightWeightStrategy {

    public static void main(String[] args) {
        //Strategy pattern we want to vary a small part of an algorithm
        //Design patterns often kick  in to fill the gaps of programming languages
        //Strategies are often a single method or function so functional interfaces and lambdas work well when this is the case
        //Lambdas are lightweight strategies
        var numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(totalValues(numbers, ignore -> true));
        System.out.println(totalValues(numbers, number -> number % 2 == 0));
        System.out.println(totalValues(numbers, LightWeightStrategy::isOdd));
        //keep in mind that strategy are stateless so lambdas match perfect for this
        // we can put different strategies and do something like this System.out.println(totalValues(numbers, BusinessLogic::someStrategy));
        //predicators are for filters
    }

    public static boolean isOdd(int number) {
        return number % 2 == 0;
    }

    public static int totalValues(List<Integer> numbers, Predicate<Integer> selector) {
        return numbers.stream()
                .filter(selector).mapToInt(e -> e).sum();
    }
}
