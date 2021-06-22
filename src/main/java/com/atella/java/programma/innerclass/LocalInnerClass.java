package com.atella.java.programma.innerclass;

/**
 * Created by chenyuan on 2018/1/10.
 */
public class LocalInnerClass {

    private int num;

    public void print() {
        String label = "Total: ";
        class Printer {
            private void printNumber() {
                System.out.println(label + num);
            }
        }
        new Printer().printNumber();
    }
}
