package com.atella.book.jvm.exec;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.io.PrintStream;

public class MethodHandleTest {

    static class ClassA {
        public void println(String s) {
            System.out.println(s);
        }
    }

    private static MethodHandle getPrintlnHM (Object receiver) throws Throwable {
        MethodType mt = MethodType.methodType(void.class,String.class);
        return MethodHandles.lookup().findVirtual(receiver.getClass(), "println", mt).bindTo(receiver);
    }

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();

        System.out.println(obj);
        // first way
        if (obj instanceof PrintStream) ((PrintStream) obj).println("W1 invoked");
        else ((ClassA) obj).println("W1 invoked");

        // second way
        // Due to the implicit type of obj, we cannot directly invoke obj.println()
        getPrintlnHM(obj).invokeExact("W2 invoked");
    }

}

