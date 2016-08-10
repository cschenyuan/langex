package com.atella.book.conarts.basic;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

/**
 * Created by yuan on 16/1/7.
 *
 * Wait/Notify Generic
 *
 * Waiter:
 * synchronized(object) {
 *     if (! condition) {
 *         object.wait();
 *     }
 *     // TO DO
 * }
 *
 * Notifier:
 * synchronized(object) {
 *     // TO DO
 *     setCondition(true);
 *     object.notifyAll();
 * }
 *
 *
*/
public class WaitNotify {
    static boolean flag = true;
    // object should be visible for both Waiter and Notifier
    static Object lock = new Object();

    static class Wait implements Runnable {
        public void run() {
            // acquire lock's LOCK
            synchronized(lock) {
                while(flag) {
                    try {
                        System.out.println(Thread.currentThread() +
                                " flag is true. wait @" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        // change to WAITING, waiting for another thread notify, and release its LOCK
                        // continue when wait() returns
                        lock.wait();
                    } catch(InterruptedException e) {

                    }
                }
                System.out.println(Thread.currentThread() + " flag is false. running@" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable {
        public void run() {
            // enter when no LOCK attaches Object lock
            synchronized(lock) {
                System.out.println(Thread.currentThread() + " hold lock. notify @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                // notify all threads that waiting for the Object 'lock'
                lock.notifyAll();
                flag = false;
                SleepUtils.second(5);
            }

            synchronized(lock) {
                System.out.println(Thread.currentThread() + " hold lock again. sleep @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.second(5);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Thread waitThread = new Thread(new Wait(),"Wait Thread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(),"Notify Thread");
        notifyThread.start();
    }
}
