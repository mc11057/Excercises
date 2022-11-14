package com.tdd.examples.modernjava;

import java.util.function.Consumer;

public class ExecuteAroundMethodPattern {
    /*
    Can be powerfully to remove the object allocation and dealocation
     */

    public static void main(String[] args) {

        Resource resource = new Resource();
        resource.op1();
        resource.op2();
        //System.gc(); this method should be renamed hope xD
        //resource.close(); //bad idea: what if there was an exception?
        // if we try with try catch the code is verbose, so don't use it
        //ARM Automatic Resource Management one good option
        try(Resource resource1= new Resource()){ //will be close automatically
                resource1.op1();
                resource1.op2();
        }
        //the better option is:
        ResourceGood.use( res -> {
            res.op1();
            res.op2();
        });

    }
}

class Resource implements AutoCloseable{
    public Resource() {
        System.out.println("created");
    }

    public Resource op1() {
        System.out.println("op1");
        return this;
    }

    public Resource op2() {
        System.out.println("op2");
        return this;
    }

    public void finalize() { //bad the method has to be explicitly call, that's why is deprecated
        System.out.println("Releasing the resource");
    }
    public void close() {
        System.out.println("Releasing the resource");
    }
}
class ResourceGood {
    private ResourceGood() {
        System.out.println("created");
    }

    public ResourceGood op1() {
        System.out.println("op1");
        return this;
    }

    public ResourceGood op2() {
        System.out.println("op2");
        return this;
    }

    public void finalize() { //bad the method has to be explicitly call, that's why is deprecated
        System.out.println("Releasing the resource");
    }
    public void close() {
        System.out.println("Releasing the resource");
    }
    public static void use(Consumer<ResourceGood> block){
        ResourceGood resourceGood = new ResourceGood();
        try{
            block.accept(resourceGood);
        } finally {
            resourceGood.close();
        }
    }

}
