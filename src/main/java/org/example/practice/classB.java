package org.example.practice;

public class classB  extends  testClass{

    static {
        System.out.println("This is static block of class b.");
    };
    {
        System.out.println("This is instance of class b. ");
    };

    public classB(){
        System.out.println("class b constructor");
    }
}
