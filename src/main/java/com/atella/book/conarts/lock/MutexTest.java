package com.atella.book.conarts.lock;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by yuan on 2016/12/29.
 */
public class MutexTest {

    @Test
    public void test() {
        Mutex mutex = new Mutex();

        Thread t1 = new Thread(() -> {
            while(true) {
                if (mutex.tryLock()) {
                    try {
                        System.out.println("Acquired synchronization state ["
                                + Thread.currentThread().getName()+"]");
                        TimeUnit.MILLISECONDS.sleep(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    } finally {
                        mutex.unlock();
                        System.out.println("Released synchronization state ["
                                + Thread.currentThread().getName()+"]");
                    }
                }
                System.out.println("[" + Thread.currentThread().getName()
                        + "] Has QueuedThread: " + mutex.isLocked());
                try {
                    TimeUnit.MILLISECONDS.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(t1);
        Thread t3 = new Thread(() -> {
            while(true) {
                mutex.lock();
                System.out.println("Acquired synchronization state ["
                        + Thread.currentThread().getName()+"]");
                try {
                    TimeUnit.MILLISECONDS.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
                mutex.unlock();
                System.out.println("[" + Thread.currentThread().getName()
                        + "] Has QueuedThread: " + mutex.isLocked());
                try {
                    TimeUnit.MILLISECONDS.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
