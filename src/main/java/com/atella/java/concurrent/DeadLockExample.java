package com.atella.java.concurrent;


/**
 * Created on 09/11/2016
 */
public class DeadLockExample {

    private static final String A = "A";
    private static final String B = "B";

    public static void main(String[] args) {

        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized(A) {
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized(B) {
                        System.out.println(B);
                    }
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                synchronized(B) {
                    synchronized(A) {
                        System.out.println(A);
                    }
                }
            }
        };

        t1.start();
        t2.start();

    }


}

