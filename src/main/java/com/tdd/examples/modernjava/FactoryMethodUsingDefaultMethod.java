package com.tdd.examples.modernjava;

public class FactoryMethodUsingDefaultMethod {

    public static void call(Person person) {
        person.play();
    }

    public static void main(String[] args) {
        //new keyword is tight coupling because explicitly says I want a type of that specific type
        //interfaces can not carry states but abstract classes can
        /*
            One Difference between abstract factory and factory method is that
            Factory method: The factory is a method not a class.
             A class or an interface relies on a derived class to provide the implementation. Use inheritance as a design tool
            Abstract factory: is a class factory.
         */
        call(new DogPerson());
        call(new CatLover());
    }
}

interface Pet {
}

class Dog implements Pet {
}

class Cat implements Pet {
}

interface Person {
    //private Pet pet; not possible
    Pet getPet(); //rather than have a field is better to have an abstract method

    default void play() {
        System.out.println("Playing with " + getPet());
    }
}

class DogPerson implements Person {
    private Dog dog = new Dog();

    public Pet getPet() {
        return dog;
    }
}

class CatLover implements Person {
    private Cat cat = new Cat();

    public Pet getPet() {
        return cat;
    }
}