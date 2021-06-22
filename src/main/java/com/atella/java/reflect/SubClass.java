package com.atella.java.reflect;

import java.lang.reflect.Method;

/**
 * @author chenyuan
 */
public class SubClass extends SuperClass {

    @Override
    void func1() {
        super.func1();
    }

    void func3() {}

    Object[] func4() { return null; }

//    public static void main(String[] args) {
//        Class cls = SubClass.class;
//        for (Method method : cls.getMethods()) {
//            System.out.println(method.getName());
//        }
//
//        System.out.println("===");
//
//        for (Method method : cls.getDeclaredMethods()) {
//            System.out.println(method.getName());
//        }
//        new SubClass();
//    }
}
