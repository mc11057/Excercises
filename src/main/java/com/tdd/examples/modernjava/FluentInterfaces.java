package com.tdd.examples.modernjava;

import java.util.function.Consumer;

class Mailer{
    private Mailer(){}
    public Mailer from(String addr){
    return this;
    }
    public Mailer to(String to){
        return this;
    }
    public Mailer subject(String subject){
        return this;
    }
    public Mailer body(String body){
        return this;
    }
    public static void send(Consumer<Mailer> consumer){
    Mailer mailer = new Mailer();
        consumer.accept(mailer);
    }
}

public class FluentInterfaces {
    public static void main(String[] args) {
        //verbose code: not excited
        /*
        Mailer mailer = new Mailer();
        mailer.from("carlosmar6977@gmail.com");
        mailer.to("example@hotmail.com");
        mailer.subject("Whatever");
        mailer.body("Body Example");
       mailer.send();
       /*
         */
        //Cascade method pattern is not a pattern itself
        Mailer.send( mail -> {
            mail.from("carlosmar6977@gmail.com")
                .to("example@hotmail.com")
                .subject("Whatever")
                .body("Body Example");
        });

    }
}
