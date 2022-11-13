package com.tdd.examples.modernjava;

import java.util.Optional;

public class OptionalsUse {

    public static void main(String[] args) {
        var result = getName();
        System.out.println(result.orElse("not found"));
        //don't do this: System.out.println(result.get());
        //use this if you really need a value
        result.orElseThrow();
        //if the value will always exist not use Optionals
        //if the result is a collection is better to return an empty collection

    }
    public static Optional<String> getName(){
        if(Math.random()>0.5)
            return Optional.of("Carlos");
        return Optional.empty();
    }
    //don't do a method like this:
    public static void setName(String name){
        if( name == null ){

        }
    }
    //don't put an Optional as a parameter is punishment for the clients of the method
    public static void setName(Optional<String> name){
        if(name.isPresent()){

        }
    }
    //it's better to use method overloading; two methods one with parameter and another without parameters
    public static void setName2( String name){
    }
    public static void setName2( ){
    }

}
