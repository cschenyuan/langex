package com.atella.book.conarts.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by yuan on 2016/12/18.
 */
public class DeadLockExample {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    static void sleep(long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void test01() {
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.submit(() -> {
            System.out.println("Acquiring lock1");
            synchronized (lock1) {
                System.out.println("Acquired lock1");
                sleep(1000L);
                System.out.println("Acquiring lock2");
                synchronized (lock2) {
                    System.out.println("Acquired lock2");
                }
            }
        });

        pool.submit(() -> {
            System.out.println("Acquiring lock2");
            synchronized(lock2) {
                System.out.println("Acquired lock2");
                sleep(1000L);
                System.out.println("Acquiring lock1");
                synchronized (lock1) {
                    System.out.println("Acquired lock1");
                }
            }
        });
    }

    public static void main(String[] args) {
        new DeadLockExample().test01();
    }
}
