package com.tdd.examples.Excercises;

import java.util.Optional;

public class FlatMapExample {


    public static void main(String[] args) {
        Optional<String> valueOpt = getValue();
        String finalValue = valueOpt.map(String::toUpperCase)
                .flatMap(upperCase->getValue2())//because this return an empty value will be redirected to orElse, will not continue with the other flatMap
                .flatMap(upperCase->getValue3(upperCase))
                .orElse("Mundo");
        System.out.println(finalValue);
    }
    public static Optional<String> getValue(){
        return Optional.of("Hola");
    }
    public static Optional<String> getValue2(){
        return Optional.empty();
    }
    public static Optional<String> getValue3(String s){
        return Optional.of("Carlos");
    }
}
