package com.atella.book.jvm.exec;

public class StaticDispatch {

    static abstract class Human {}

    static class Man extends Human {}

    static class Woman extends Human {}

    void sayHello(Human human) {
        System.out.println("Hello, human");
    }

    void sayHello(Man man) {
        System.out.println("Hello, man");
    }

    void sayHello(Woman woman) {
        System.out.println("Hello, women");
    }

    public static void main(String[] args) {
        StaticDispatch dispatch = new StaticDispatch();
        Human man = new Man();
        Human woman = new Woman();
        dispatch.sayHello(man);
        dispatch.sayHello(woman);
        dispatch.sayHello((Man) man);
        dispatch.sayHello((Woman) woman);
    }

}
