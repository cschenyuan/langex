package com.atella.book.conarts.basic;


import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yuan on 16/1/14.
 */
public class LockTest {

    @Test
    public void twinsLockTest() {
        Lock lock = new TwinsLock();

        class Worker extends Thread {
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }

        for(int i=0;i<10;i++) {
            Worker worker = new Worker();
            worker.setDaemon(true);
            worker.start();
        }

        for (int i=0;i<10;i++) {
            SleepUtils.second(1);
            System.out.println();
        }
    }

    @Test
    public void testReentrantLock01() {
        Lock unfairLock = new ReentrantLock(false);
        Lock fairLock = new ReentrantLock(true);

        class Worker extends Thread {
            private Lock lock;
            private int n;
            Worker(int n,Lock lock) {
                this.lock = lock;
                this.n = n;
            }
            public void run() {
                lock.lock();
                try {
                    System.out.println("Owned by " + n);
                } finally {
                    lock.unlock();
                }
            }
        }

        // fair lock
       // for(int i=0;i<5;i++) {
       //     Worker worker = new Worker(i,fairLock);
       //     worker.setDaemon(true);
       //     worker.start();
       // }

        // unfair lock
        for(int i=0;i<5;i++) {
            Worker worker = new Worker(i,unfairLock);
            worker.start();
        }
    }

    @Test
    public void testLockSupport() {
        //LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(5));
        // get supported in Java 6
        LockSupport.parkNanos(this,TimeUnit.SECONDS.toNanos(5));
    }
}


