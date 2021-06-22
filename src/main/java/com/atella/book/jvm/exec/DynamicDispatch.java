package com.atella.book.jvm.exec;


public class DynamicDispatch {

    static abstract class Human {
        void sayHello() {}
    }

    static class Man extends Human {
        @Override
        void sayHello() {
            System.out.println("Man says hello");
        }
    }

    static class Woman extends Human {
        @Override
        void sayHello() {
            System.out.println("Woman says hello");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();
    }
}
