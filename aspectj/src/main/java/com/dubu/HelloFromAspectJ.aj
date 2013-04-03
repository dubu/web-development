package com.dubu;


public aspect HelloFromAspectJ {


    long startTime ;

    pointcut mainMethod(): execution(public static void main(String[]));

    before(): mainMethod() {

        System.out.println("*** start job time ***");
        startTime = System.currentTimeMillis();
    }

    after() returning : mainMethod() {
        System.out.println("*** end job time ***");
        System.out.println("process time : " + (System.currentTimeMillis() - startTime) + " ms");

    }
}