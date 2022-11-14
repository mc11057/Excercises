package com.tdd.examples.modernjava;


import java.awt.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class DecoratorUsingLambdas {

    public static void main(String[] args) {
        /*
            Functions are composable is an amazing capability
         */
        Function<Integer,Integer> inc = value -> value + 1;
        Function<Integer,Integer> doubled = value -> value * 2;
        print(5,"incremented",inc);
        print(5,"double",doubled);
        //increment and double
        //print(5,"incremented and doubled",value->(value+1)*2);// this is bored
        print(5,"increment and double",inc.andThen(doubled));
    }
    public static void print(int number, String message,Function<Integer,Integer> func){
        System.out.println(number+" "+message+": "+ func.apply(number));
    }

}
class Camera {
    private Function<Color,Color> filter;
    public Camera (Function<Color,Color>... filters){
        filter = Stream.of(filters).reduce(Function.identity(),Function::andThen);
    }
    public Color snap(Color input){
        return input;
    }
}
 class Sample {
    public static void print(Camera camera){
        System.out.println(camera.snap(new Color(125,125,125)));
    }
     public static void main(String[] args) {
        print(new Camera());
        print(new Camera(color->color.brighter()));
        print(new Camera(Color::brighter));
        //Decorator pattern using many combinations for example:
        print(new Camera(Color::brighter,Color::darker));

     }
 }
