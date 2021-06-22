package com.atella.java.reflect;

import java.lang.reflect.Method;

/**
 * @author chenyuan
 */
public class SuperClass {

    public SuperClass() {
        Class cls = getClass();
        for (Method method : cls.getMethods()) {
            System.out.println(method.getName());
        }

        System.out.println("===");

        for (Method method : cls.getDeclaredMethods()) {
            System.out.println(method.getName());
        }
    }

    void func1() {}

    void func2() {}

}
