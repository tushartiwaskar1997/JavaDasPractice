package org.example.practice;

public class testClass {

    static {
        System.out.println("this is static block of class A ");
    };
    {
        System.out.println("parent class instatnce block.");
    };
    public testClass(){
        System.out.println("parent constructor.");
    }
}
