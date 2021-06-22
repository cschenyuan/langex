package com.atella.book.jvm.exec;

import java.io.Serializable;

public class Overload {

    static void sayHello(char c) {
        System.out.println("Hello, char.");
    }

    static void sayHello(int c) {
        System.out.println("Hello, int.");
    }

    static void sayHello(long c) {
        System.out.println("Hello, long.");
    }

    static void sayHello(Character c) {
        System.out.println("Hello, Charactar.");
    }

    static void sayHello(Serializable c) {
        System.out.println("Hello, Serializable.");
    }

    static void sayHello(Object c) {
        System.out.println("Hello, Object.");
    }

    static void sayHello(char...c) {
        System.out.println("Hello, char....");
    }

    public static void main(String[] args) {
        // char > int > long > Charactar > Serializable > Object > char...
        sayHello('s');
    }
}
