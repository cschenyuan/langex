package com.atella.book.conarts.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yuan on 2016/11/18.
 */
public class ThreadLocalExample {

    static class ThreadID {
        private static AtomicInteger ID = new AtomicInteger(0);
        private static final ThreadLocal<Integer>
                T_LOCAL = new ThreadLocal<Integer>() {
            protected Integer initialValue() {
                return ID.incrementAndGet();
            }
        };

        static int getThreadId() {
            return T_LOCAL.get();
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"'s ID: "
                        + ThreadID.getThreadId());
            },"t-"+i).start();
        }
    }
}
