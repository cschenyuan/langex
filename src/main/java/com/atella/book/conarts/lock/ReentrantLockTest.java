package com.atella.book.conarts.lock;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by chenyuan on 2018/1/19.
 */
public class ReentrantLockTest {

    @Test
    public void testLock() {
        ReentrantLock lock = new ReentrantLock();

        int numThread = 4;
        ExecutorService executor = Executors.newFixedThreadPool(numThread);

        for (int i=0; i<numThread; i++) {
            executor.execute(() -> {
                try {
                    if (lock.tryLock()) {
                        try {
                            System.out.println("executing..." + Thread.currentThread().toString());
                            TimeUnit.SECONDS.sleep(3L);
                        } finally {
                            lock.unlock();
                        }
                    } else {
                        System.out.println("waiting " + Thread.currentThread().toString());
                        lock.lock();
                        try {
                            System.out.println("signaled " + Thread.currentThread().toString());
                        } finally {
                            lock.unlock();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();

    }

    public void testObject() {
        ReentrantLock lock = new ReentrantLock();
        final Object object = new Object();

        int numThread = 4;
        ExecutorService executor = Executors.newFixedThreadPool(numThread);

        for (int i=0; i<numThread; i++) {
            executor.execute(() -> {
                try {
                    if (lock.tryLock()) {
                        try {
                            System.out.println("executing..." + Thread.currentThread().toString());
                            TimeUnit.SECONDS.sleep(3L);
                        } finally {
                            lock.unlock();
                            synchronized (object)  {
                                object.notifyAll();
                            }
                        }
                    } else {
                        while (lock.isLocked()) {
                            System.out.println("waiting " + Thread.currentThread().toString());
                            synchronized (object) {
                                object.wait();
                            }
                        }
                        System.out.println("signaled " + Thread.currentThread().toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
    }

    public static void main(String[] args) {
        ReentrantLockTest test = new ReentrantLockTest();
//        test.testObject();
        test.testLock();
    }
}
